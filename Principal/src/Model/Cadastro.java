package Model;

import Repository.AlunoDAO;
import Repository.RelatorioAlunoForm;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

import static Repository.RelatorioAlunoForm.emitirRelatorio;

public class Cadastro {

public static Object chamamenuprincipal(){

    String[] opcoesMenuCadastro = {"Cadastro", "Relatório", "Sair"};
    int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
            "Menu Cadastros",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

    switch (menuCadastro){

        case 0: //CadastroAluno

            String nome = JOptionPane.showInputDialog(null, "Informe o seu nome: ");
            String email = JOptionPane.showInputDialog(null, "Informe o seu e-mail: ");
            String telefone = JOptionPane.showInputDialog(null, "Informe o seu telefone: ");
            String dataNascimento = JOptionPane.showInputDialog(null, "Informe a sua data de nascimento: ");
            String nota1 = JOptionPane.showInputDialog(null, "Informe a sua primeira nota: ");
            Double nota1convertido = Double.valueOf(nota1);
            String nota2 = JOptionPane.showInputDialog(null, "Informe a sua segunda nota: ");
            Double nota2convertido = Double.valueOf(nota2);
            String nota3 = JOptionPane.showInputDialog(null, "Informe a sua terceira nota: ");
            Double nota3convertido = Double.valueOf(nota3);
            String nota4 = JOptionPane.showInputDialog(null, "Informe a sua quarta nota: ");
            Double nota4convertido = Double.valueOf(nota4);


            //AlunoDAO.mostrar();



            double media = ((nota1convertido + nota2convertido + nota3convertido + nota4convertido) /4);

            if (media >= 7) {
                JOptionPane.showMessageDialog(null, "Aprovado " + "\nMédia: " + media, "Média", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Reprovado "+ "\nMédia: " + media, "Média", JOptionPane.INFORMATION_MESSAGE);
            }

            Aluno aluno = new Aluno(nome, email, telefone, dataNascimento, nota1convertido,nota2convertido, nota3convertido, nota4convertido, media );
            AlunoDAO.salvar(aluno);
            chamamenuprincipal();
            break;

        case 1: //
            List<Aluno> alunos = AlunoDAO.buscarTodos();
            RelatorioAlunoForm.emitirRelatorio(alunos);
            break;
    }




    return null;
}

}
