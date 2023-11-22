package sistemacrudpaciente;
 
import java.util.Scanner;
 
 
public class sistemacrudpaciente {
 
    public static int MAX_PACIENTES = 100;
    public static Paciente[] pacientes = new Paciente [MAX_PACIENTES];
    public static Scanner input = new Scanner(System.in);
    public static int indice = 0;
    public static void main (String[] args){
        menu();
        cadastrar();
        procurar();
        alterar();
        remover();
        listar();
    }

    public static void cadastrar(){
        System.out.println("CADASTRAR PACIENTE");
        System.out.println("Digite os dados do paciente.");
        System.out.println("Digite o nome do paciente: ");
        String nome = input.nextLine();
        System.out.println("Digite o CPF do paciente: ");
        double cpf = input.nextDouble();
        System.out.println("Digite o telefone do paciente: ");
        double telefone = input.nextDouble();
        input.nextLine();
        Paciente p = new Paciente();
        p.nome = nome; 
        p.cpf = cpf;
        p.telefone = telefone; 
        p.id = indice + 1;
        pacientes[indice] = p;
        indice += 1;
    }
    public static void procurar(){
        System.out.println("PROCURAR PACIENTE");
        System.out.println("Digite o nome do paciente a ser procurado: ");
        String nome = input.nextLine();
        for(int i =0; i< indice; i++){
            Paciente p = pacientes[i];
            if(p.nome.contains(nome)){
                System.out.println("Produto Encontrado");
                System.out.println("Nome: " + p.nome);
                System.out.println("CPF: "+ p.cpf);
                System.out.println("Telefone: "+ p.telefone);
                break;
            }
        }
    }
    public static void alterar(){
        System.out.println("ALTERAR PACIENTE");
        System.out.println("Digite o nome do paciente a ser procurado: ");
        String nome = input.nextLine();
        for(int i =0; i< indice; i++){
            Paciente p = pacientes[i];
            if(p.nome.equalsIgnoreCase(nome)){
                System.out.println("Digite o novo nome do paciente: ");
                p.nome = input.nextLine();
                System.out.println("Digite o novo CPF do paciente: ");
                p.cpf = input.nextDouble();
                System.out.println("Digite o novo telefone do paciente: ");
                p.telefone = input.nextDouble();
                input.nextLine();
               break;
            }
        }
    }
  public static void remover(){
        System.out.println("REMOVER PACIENTE");
        System.out.println("Digite o nome do paciente a ser REMOVIDO: ");
        String nome = input.nextLine();
        for(int i =0; i< indice; i++){
            Paciente p = pacientes[i];
            if(p != null && p.nome.equalsIgnoreCase(nome)){
                pacientes[i] = null;
                break;
            }
        }    
  }

  public static void listar(){
  System.out.println("Nome\t\tCPF\t\tTelefone");
       for(int i = 0; i<indice; i++){
           Paciente p = pacientes[i];
           if( p != null){
               System.out.println(p.nome + "\t\t" + p.cpf + "\t\t" + p.telefone);
               
           }
           
       }
  
  }
    public static void menu(){
        boolean terminar = false;
        while (!terminar){
        System.out.println("**GESTÃO DE PACIENTES**");
        System.out.println("(C)adastrar");
        System.out.println("(P)rocurar");
        System.out.println("(A)lterar");
        System.out.println("(R)emover");
        System.out.println("(L)istar");
        System.out.println("(S)air");
        System.out.println("Por favor escolha uma opção: ");
        String escolha = input.nextLine();
        if(escolha.length()>0){
        char op = escolha.toLowerCase().charAt(0);
            switch (op) {
                case 'c':
                    cadastrar();
                    break;
                case 'p':
                    procurar();
                    break;
                case 'a':
                    alterar();
                    break;
                case 'r':
                    remover();
                    break;
                case 'l':
                    listar();
                    break;
                case 's':
                    System.out.println("Até logo...");
                    terminar = true;
                    break;
                default:
                    break;
            }
        }
    }    
}
}