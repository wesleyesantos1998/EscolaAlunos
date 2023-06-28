package Repository;

import Model.Aluno;

import java.util.ArrayList;
import java.util.List;

import static org.omg.CORBA.ORB.init;

public class AlunoDAO {

    static List<Aluno> AlunoLista = new ArrayList<>();

public static void salvar(Aluno aluno){
    AlunoLista.add(aluno);

}

public static void mostrar(){
    System.out.println(AlunoLista);
    }

    public static List<Aluno> buscarTodos() {
        return AlunoLista;
    }



}
