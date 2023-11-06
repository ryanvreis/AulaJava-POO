package curso.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.statusAluno;

public class primeiraClasseJava {
	public static void main(String[] args) {
		
		String login = JOptionPane.showInputDialog("Informe o login: ");
		String senha = JOptionPane.showInputDialog("Informe a senha: ");
		
		if(login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			
		

		List<Aluno> alunos = new ArrayList<Aluno>();

		/*
		 * É uma lista que dentro dela temos uma chave que identifica uma sequência de
		 * valores também
		 */
		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

		for (int qtd = 1; qtd <= 5; qtd++) {

			/* New aluno() é uma instância(Criação de Objeto) */
			/* aluno1 é uma referência para o Objeto "Aluno" */

			String nome = JOptionPane.showInputDialog("Qual é o nome do aluno" + qtd + "?");
			/*
			 * String idade = JOptionPane.showInputDialog("Qual a idade do aluno?"); String
			 * dataNascimento =
			 * JOptionPane.showInputDialog("Qual a data de nascimento do aluno?"); String
			 * registroGeral = JOptionPane.showInputDialog("Qual é o RG do aluno?"); String
			 * cpf = JOptionPane.showInputDialog("Qual é o CPF do aluno?"); String mae =
			 * JOptionPane.showInputDialog("Qual o nome da mãe do aluno?"); String pai =
			 * JOptionPane.showInputDialog("Qual o nome do pai do aluno?"); String matricula
			 * = JOptionPane.showInputDialog("Qual o numero de mátricula do aluno?"); String
			 * escola = JOptionPane.showInputDialog("Qual o nome da escola do aluno?");
			 * String serie =
			 * JOptionPane.showInputDialog("Qual o numero da série do aluno?");
			 */

			Aluno aluno1 = new Aluno();

			aluno1.setNome(nome);
			/*
			 * aluno1.setIdade(Integer.valueOf(idade));
			 * aluno1.setDataNascimento(dataNascimento);
			 * aluno1.setRegistroGeral(registroGeral); aluno1.setNumeroCPF(cpf);
			 * aluno1.setNomeMae(mae); aluno1.setNomePai(pai);
			 * aluno1.setDataMatricula(matricula); aluno1.setNomeEscola(escola);
			 * aluno1.setSerieMatriculado(serie);
			 */

			for (int pos = 1; pos <= 1; pos++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina:" + pos + "?");
				String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina:" + pos + "?");

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));

				aluno1.getDisciplinas().add(disciplina);
			}
			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");

			if (escolha == 0)/* Opção SIM é "zero" */ {

				int continuarRemover = 0;
				int posicao = 1;

				while (continuarRemover == 0) {
					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4? ");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					posicao++;
					continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover? ");
				}
			}
			alunos.add(aluno1);
		}
		maps.put(statusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(statusAluno.RECUPERACAO, new ArrayList<Aluno>());
		maps.put(statusAluno.REPROVADO, new ArrayList<Aluno>());

		for (Aluno aluno : alunos) {
			if (aluno.getAlunoAprovado2().equalsIgnoreCase(statusAluno.APROVADO)) {
				maps.get(statusAluno.APROVADO).add(aluno);
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(statusAluno.RECUPERACAO)) {
				maps.get(statusAluno.RECUPERACAO).add(aluno);
			} else {
				maps.get(statusAluno.REPROVADO).add(aluno);
			}
		}
		System.out.println(
				"-------------------------------------- Lista dos Aprovados --------------------------------------");
		for (Aluno aluno : maps.get(statusAluno.APROVADO)) {
			System.out.println("O aluno " + aluno.getNome() + " obteve o resultado = " + aluno.getAlunoAprovado2()
					+ " com média de = " + aluno.getMediaNota());
		}
		System.out.println(
				"-------------------------------------- Lista Recuperação --------------------------------------");
		for (Aluno aluno : maps.get(statusAluno.RECUPERACAO)) {
			System.out.println("O aluno " + aluno.getNome() + " obteve o resultado = " + aluno.getAlunoAprovado2()
					+ " com média de = " + aluno.getMediaNota());
		}
		System.out.println(
				"-------------------------------------- Lista dos Reprovados --------------------------------------");
		for (Aluno aluno : maps.get(statusAluno.REPROVADO)) {
			System.out.println("O aluno " + aluno.getNome() + " obteve o resultado = " + aluno.getAlunoAprovado2()
					+ " com média de = " + aluno.getMediaNota());
		}
	}
	}
}