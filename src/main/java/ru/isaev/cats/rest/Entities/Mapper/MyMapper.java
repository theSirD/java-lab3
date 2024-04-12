package ru.isaev.cats.rest.Entities.Mapper;

import org.springframework.stereotype.Component;
import ru.isaev.cats.rest.Entities.CatDtos.CatDto;
import ru.isaev.cats.rest.Entities.Cats.Cat;
import ru.isaev.cats.rest.Entities.OwnerDtos.OwnerDto;
import ru.isaev.cats.rest.Entities.Owners.Owner;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Component
public class MyMapper implements IMyMapper {

    private final DatatypeFactory datatypeFactory;

    public MyMapper() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public CatDto catToCatDto(Cat cat) {
        if ( cat == null ) {
            return null;
        }

        CatDto catDto = new CatDto();

        catDto.setId( cat.getId() );
        catDto.setBirthday( xmlGregorianCalendarToString( dateToXmlGregorianCalendar( cat.getBirthday() ), null ) );
        catDto.setColor( cat.getColor() );
        catDto.setBreed( cat.getBreed() );
        catDto.setOwnerId(cat.getOwner().getId());

//        catDto.setFriends(cat.getFriendsList());
        Set<Cat> listOfFriends = cat.getFriendsList();
        Set<Long> idsOfFriends = new HashSet<>();

        for (Cat friend:
             listOfFriends) {
            idsOfFriends.add(friend.getId());
        }

        catDto.setFriends(idsOfFriends);


        return catDto;
    }

    @Override
    public Set<CatDto> catsSetToCatDtosSet(Set<Cat> setOfCats) {
        Set<CatDto> setOfCatDtos = new HashSet<>();

        for (Cat cat :
                setOfCats) {
            setOfCatDtos.add(catToCatDto(cat));
        }

        return setOfCatDtos;
    }


    @Override
    public OwnerDto ownerToOwnerDto(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDto ownerDto = new OwnerDto();

        ownerDto.setId(owner.getId());
        ownerDto.setFirst_name(owner.getFirst_name());
        ownerDto.setLast_name(owner.getLast_name());
        ownerDto.setBirthday( xmlGregorianCalendarToString( dateToXmlGregorianCalendar( owner.getBirthday() ), null ) );

//        ownerDto.setCats(owner.getCatsList());

        Set<Cat> catsList = owner.getCatsList();
        Set<Long> idsOfCats = new HashSet<>();

        for (Cat cat:
                catsList) {
            idsOfCats.add(cat.getId());
        }

        ownerDto.setCats(idsOfCats);

        return ownerDto;
    }

    private String xmlGregorianCalendarToString(XMLGregorianCalendar xcal, String dateFormat ) {
        if ( xcal == null ) {
            return null;
        }

        if (dateFormat == null ) {
            return xcal.toString();
        }
        else {
            Date d = xcal.toGregorianCalendar().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );
            return sdf.format( d );
        }
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
    }
}
