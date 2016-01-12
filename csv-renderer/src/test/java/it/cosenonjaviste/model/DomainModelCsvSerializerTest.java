package it.cosenonjaviste.model;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by acomo on 12/01/16.
 */
public class DomainModelCsvSerializerTest {

    @Test
    public void shouldRender2Lines() throws Exception {
        DomainModelCsvSerializer serializer = new DomainModelCsvSerializer();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        serializer.serializeTo(getRows(), out);

        String csv = new String(out.toByteArray());
        assertNotNull(csv);
        assertFalse(csv.isEmpty());
        assertEquals(
                "123,Fri Dec 25 00:00:00 CET 2015,123.4,test\n" +
                "321,Sat Dec 26 00:00:00 CET 2015,321.9,test2", csv);
    }

    private List<DomainModel> getRows() throws ParseException {
        List<DomainModel> list = new ArrayList<>();
        list.add(getDomainModel("test", "25/12/2015", 123, 123.4f));
        list.add(getDomainModel("test2", "26/12/2015", 321, 321.9f));

        return list;
    }

    private DomainModel getDomainModel(String value1, String value2, int value3, float value4) throws ParseException {
        DomainModel model = new DomainModel();
        model.setValue1(value1);
        model.setValue2(new SimpleDateFormat("dd/MM/yyyy").parse(value2));
        model.setValue3(value3);
        model.setValue4(value4);
        return model;
    }

}