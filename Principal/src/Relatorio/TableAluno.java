package Relatorio;

import Model.Aluno;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableAluno extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    public static final int INDEX_nome = 0;
    public static final int INDEX_email = 1;
    public static final int INDEX_telefone = 2;
    public static final int INDEX_dataNascimento = 3;
    public static final int INDEX_nota1 = 4;
    public static final int INDEX_nota2 = 5;
    public static final int INDEX_nota3 = 6;
    public static final int INDEX_nota4 = 7;
    public static final int INDEX_media = 8;
    public static final int INDEX_ESCONDIDO = 9;



    protected String[] nomeColunas;
    protected Vector<Aluno> vetorDados;

    public TableAluno(String[] columnNames, Vector<Aluno> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Aluno registroAluno = (Aluno) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_nome:
                return registroAluno.getNome();
            case INDEX_email:
                return registroAluno.getEmail();
            case INDEX_telefone:
                return registroAluno.getTelefone();
            case INDEX_dataNascimento:
                return registroAluno.getDataNascimento();
            case INDEX_nota1:
                return registroAluno.getNota1();
            case INDEX_nota2:
                return registroAluno.getNota2();
            case INDEX_nota3:
                return registroAluno.getNota3();
            case INDEX_nota4:
                return registroAluno.getNota4();
            case INDEX_media:
                return registroAluno.getMedia();

            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}
