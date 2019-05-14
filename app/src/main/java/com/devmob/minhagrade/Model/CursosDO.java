package com.devmob.minhagrade.Model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMarshalling;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DevMob on 17/05/2017.
 */
@DynamoDBTable(tableName = "curso")
public class CursosDO {

    private String _id;
    private String nome;
    private int periodos;
    private List<Discipline> disciplinas = new ArrayList<>();

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAttribute(attributeName = "id")
    public String getId() {
        return _id;
    }

    public void setId(final String _id){
        this._id = _id;
    }

    @DynamoDBAttribute(attributeName = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(final String nome){
        this.nome = nome;
    }

    @DynamoDBAttribute(attributeName = "periodos")
    public int getPeriodos(){
        return periodos;
    }

    public void setPeriodos(final int periodos){
        this.periodos = periodos;
    }

    @DynamoDBMarshalling(marshallerClass = DisciplineMarshaller.class)
    @DynamoDBAttribute(attributeName = "disciplinas")
    public List<Discipline> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(final List<Discipline> disciplinas){
        this.disciplinas = disciplinas;
    }
}
