package com.devmob.minhagrade.Model;


/**
 * Created by DevMob on 17/05/2017.
 */

public class Disciplina {
    private String nome;
    /**
     * Status: 0 para não feito, 1 para fazendo e 2 para feito
     */
    private int status;
    private int periodo;
    private String periodoString;
    private int id;

    public Disciplina(int id,String nome, int status, String periodoString) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.periodoString = periodoString;
    }

    public Disciplina(String nome, int status, String periodoString) {
        this.nome = nome;
        this.status = status;
        this.periodoString = periodoString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodo(){
        return periodo;
    }

    public String getPeriodoString() {
        return periodoString;
    }

    public void setPeriodoString(String periodoString) {
        this.periodoString = periodoString;
    }

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome.toString();
    }
    public int getStatus(){
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString(){
        return "Disciplina:"+nome+" Status:"+status+" Periodo:"+ periodoString +"\n";
    }


    // Metodo que pega as disciplinas do Resource para a Activity
//    public static ArrayList<Disciplina> getDisciplinas(ArrayList<String> value, Context context){
//        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
//        String[] disciplinasVetor = new String[0];
//        int n = 0;
//        Resources res = context.getResources();
//        String[][] array = new String[0][];
//        try {
//            Field field = R.array.class.getField(value.get(0));
//            TypedArray ta = res.obtainTypedArray(field.getInt(null));
//            n = ta.length();
//            array = new String[n][];
//            for (int i = 0; i < n; ++i) {
//                int id = ta.getResourceId(i, 0);
//                if (id > 0) {
//                    array[i] = res.getStringArray(id);
//                } else {
//                    // something wrong with the XML
//                }
//            }
//            ta.recycle(); // Important!
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        String indice = value.get(1);
//        int status;
//        int quantidade = 0;
//        for (int i = 0; i<n; i++){
//            quantidade = quantidade+array[i].length;
//        }
//
////        Log.i("Quantidade:", String.valueOf(quantidade));
//        Prefs.setInteger(context,"QuantidadeDisciplinas",quantidade);
//
//        disciplinasVetor = array[Integer.parseInt(String.valueOf(indice.charAt(0)))-1];
//        for (int i = 0;i<disciplinasVetor.length;i++){
//            status = Prefs.getInt(context,disciplinasVetor[i]);
//            if (status == 0) {
//                disciplinas.add(new Disciplina(disciplinasVetor[i]));
//            }
//            else {
//                disciplinas.add(new Disciplina(disciplinasVetor[i], status));
//            }
//        }
//        //Log.i("Disciplina",disciplinas.getClass().toString());
//        return disciplinas;
//    }
//
//    // Metodo que pega as disciplinas do Resource para a Activity
//    public static ArrayList<Disciplina> getDisciplinasPorStatus(ArrayList<String> value, Context context,int st){
//        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
//        String[] disciplinasVetor = new String[0];
//        int n = 0;
//        Resources res = context.getResources();
//        String[][] array = new String[0][];
//        Log.i("Get0",value.get(0));
//        Log.i("Get1",value.get(1));
//        try {
//            Field field = R.array.class.getField(value.get(0));
//            TypedArray ta = res.obtainTypedArray(field.getInt(null));
//            n = ta.length();
//            array = new String[n][];
//            for (int i = 0; i < n; ++i) {
//                int id = ta.getResourceId(i, 0);
//                if (id > 0) {
//                    array[i] = res.getStringArray(id);
//                } else {
//                    // something wrong with the XML
//                }
//            }
//            ta.recycle(); // Important!
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        int status;
//        int quantidade = 0;
//        for (int i = 0; i<n; i++){
//            quantidade = quantidade+array[i].length;
//        }
//
////        Log.i("Quantidade:", String.valueOf(quantidade));
////        Prefs.setInteger(context,"QuantidadeDisciplinas",quantidade);
//        int indice;
//        for(indice=0;indice<value.size()-1;indice++) {
//            disciplinasVetor = array[indice];
//            for (int i = 0; i < disciplinasVetor.length; i++) {
//                status = Prefs.getInt(context, disciplinasVetor[i]);
//                if (status == st) {
//                    disciplinas.add(new Disciplina(disciplinasVetor[i]));
////                    Log.i("d",disciplinasVetor[i]);
//                }
//            }
//        }
//        //Log.i("Disciplina",disciplinas.getClass().toString());
//        return disciplinas;
//    }
}
