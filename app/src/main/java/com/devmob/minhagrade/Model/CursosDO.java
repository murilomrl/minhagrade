package com.devmob.minhagrade.Model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMarshalling;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;

/**
 * Created by Murilo on 14/05/2019.
 */
@DynamoDBTable(tableName = "curso")
public class CursosDO {

    private String _id;
    private String nome;
    private int periodos;
    private List<Map<Integer, String>> disciplinas;

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
    public List<Map<Integer, String>> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(final List<Map<Integer,String>> disciplinas){
        this.disciplinas = disciplinas;
    }
}
