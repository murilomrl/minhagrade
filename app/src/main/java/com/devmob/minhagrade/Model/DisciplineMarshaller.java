package com.devmob.minhagrade.Model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.JsonMarshaller;

public class DisciplineMarshaller extends JsonMarshaller<Discipline> {
    /*@Override
    public String marshall(Discipline discipline) {
        return "{nome: " + discipline.getNome() + ", periodo: " + discipline.getPeriodo() + "}";
    }

    @Override
    public Discipline unmarshall(Class<Discipline> clazz, String obj) {
        String[] s = obj.split(" ");
        Discipline discipline = new Discipline();
        discipline.setNome(s[1].substring(0,s[1].length() - 1));
        discipline.setPeriodo(Integer.parseInt(s[3].substring(0,s[3].length() - 1)));
        return discipline;
    }*/
}
