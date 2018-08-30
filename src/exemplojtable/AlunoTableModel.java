/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplojtable;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danilo
 */
public class AlunoTableModel extends AbstractTableModel {

    private List<Aluno> alunos = new ArrayList<>();
    private String[] colunas = {"Nome", "E-mail", "RA"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return alunos.get(linha).getNome();
            case 1:
                return alunos.get(linha).getEmail();
            case 2:
                return alunos.get(linha).getRa();

        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                alunos.get(linha).setNome((String) valor);
                break;
            case 1:
                alunos.get(linha).setEmail((String) valor);
                break;
            case 2:
                alunos.get(linha).setRa(Integer.parseInt((String) valor));
                break;
        }
        this.fireTableRowsUpdated(linha, linha);

    }

    public void addLinha(Aluno a) {
        this.alunos.add(a);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.alunos.remove(linha);
        this.fireTableDataChanged();
    }

}
