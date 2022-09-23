import Ancoragem.Estudante;
import Ancoragem.Curso;
import Ancoragem.Professor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    static List<Curso> Cursos = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Professor p1 = new Professor("Steve");
        List<Integer> opcoes = new ArrayList<>();
        opcoes.add(1);
        opcoes.add(2);
        opcoes.add(3);
        opcoes.add(4);
        opcoes.add(5);
        opcoes.add(6);

        int escolha = 1;
        while (opcoes.get(escolha) != 6) {
            escolha = exibeMenu(opcoes);
            if (opcoes.get(escolha) == 1) {
                cadastrarCurso(p1);
            } else if (opcoes.get(escolha) == 2) {
                matricularEstudante();
            } else if (opcoes.get(escolha) == 3) {
                mostrarCursos();
            } else if (opcoes.get(escolha) == 4) {
                mostrarEstudante();
            }
        }
        System.out.println(Cursos.size());
    }
    // A partir daqui: cadastro de Curso!
    private static void cadastrarCurso(Professor p1) {
        String nome_do_Curso = JOptionPane.showInputDialog("Informe o nome do Curso");
        String nivel_do_Curso = JOptionPane.showInputDialog("Informe o nível do Curso");
        String ch_do_Curso = JOptionPane.showInputDialog("Informe a CH do Curso");
        Curso novo_Curso = new Curso(nome_do_Curso, nivel_do_Curso, Integer.parseInt(ch_do_Curso), p1);
        Cursos.add(novo_Curso);
    }
    // A partir daqui: Matrícula de Estudante!
    private static void matricularEstudante() {
        List<String> opcoes = new ArrayList<>();
        for (Curso Curso : Cursos) {
            opcoes.add(Curso.getNome());
        }
        Object[] optionsArray = opcoes.toArray();
        int opcaoEscolhida = JOptionPane.showOptionDialog(null,
                "Selecion o Curso",
                "Cursos",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                optionsArray, null);

        String nomeCursoSelecionado = opcoes.get(opcaoEscolhida);
        String nome_do_Estudante = JOptionPane.showInputDialog("Informe o nome do Estudante");
        String email_do_Estudante = JOptionPane.showInputDialog("Informe o email do Estudante");

        Estudante novoEstudante = new Estudante(nome_do_Estudante, email_do_Estudante);

        for (Curso curso : Cursos) {
            if (curso.getNome().equals(nomeCursoSelecionado)) {
                curso.realizarMatricula(novoEstudante);
                break;
            }
        }
    }
    // A partir daqui: exibição de Curso!
    private static void mostrarCursos() {
        String info = "";
        for (Curso Curso : Cursos) {
            info = info + Curso.getNome() + " ch: " + Curso.getCh() + "\n";
            for (Estudante Estudante : Curso.getEstudante()) {
                info = info + " - " + Estudante.getNome() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, info, "Cursos", JOptionPane.PLAIN_MESSAGE);
    }
    // A partir daqui: exibição de Estudante!
    private static void mostrarEstudante() {
    }
    // A partir daqui: exibição do Menu!
    private static int exibeMenu(List<Integer> opcoes) {
        Object[] optionsArray = opcoes.toArray();
        int opcaoEscolhida = JOptionPane.showOptionDialog(null,
                "1. Cadastrar_Curso \n2. Cadastrar_Estudante \n3. mostrar_Cursos \n 4.mostrar_Estudantes \n5. Certificado \n6. Finalizar",
                "Escolha:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                optionsArray, null);
        return opcaoEscolhida;
    }
}
