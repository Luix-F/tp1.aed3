import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Method;

public class tp1 {
    static String info = "                             |";
    static String md1 = "|       Modo Tester                  ";
    static String md2 = "./csv/Airplanev5_2.csv";
    static String md3 = "./dbs/jj.db";

    static int limitMemory = 4;
    static int ordB = 4;

    public static void main(String[] args) {
        MyIO.setCharset("iso-8859-1");// iso-8859-1

        Cruda cr = new Cruda();
        intercar1 inte1 = new intercar1();
        intercalar2 inte2 = new intercalar2();
        hashira dasChamas = new hashira();
        listaInvertida invetes = new listaInvertida();
        //arvB avb = new arvB();
        
        //System.out.println(dasChamas.searcheando(2));

        
        Scanner sc_man = null;
        int key = -1;
        int page = 1;

        try {
            // Limpa a tela no windows, no linux e no MacOS
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "color 07").inheritIO().start().waitFor();
            }
        } catch (InterruptedException | IOException e) {
            // Todo Auto-generated catch block
            e.printStackTrace();
        }
        //limpar();
        sc_man = new Scanner(System.in);
        //key = 86;
        do {
            menu(page);
            key = sc_man.nextInt();
            
            //sc_man.nextLine(); // evita erros devido ao scanner de "int";
            limpar();
            info = "                             |";
            switch (key) {
                case 1: // puxa o csv e transforma em db;
                    CsvForDb();
                    limpar();
                    break;
                case 2: // Apenas printa o arquivo db no console;
                    lerdb((byte) 0);
                    break;
                case 3: // Cria uma nova linha;
                    cr.novaLinha((int) 0);
                    break;
                case 4: // Encontrar linha pelo ID;
                    System.out.print("\nInsira o identificador ID da linha: ");
                    cr.printaSelecao(cr.encontrar(sc_man.nextInt()));
                    break;
                case 5:
                    System.out.print("\n 0 retorna ao menu: ");
                    System.out.print("\nInsira o identificador ID do registro a ser DELETADO: ");
                    key = sc_man.nextInt();
                    if (key != 0) { cr.delet(key); }
                    break;
                case 6:
                    System.out.print("\n 0 retorna ao menu: ");
                    System.out.print("\nInsira o identificador ID do registro a ser alterado: ");
                    key = sc_man.nextInt();
                    if (key != 0) {
                        cr.atualizarRegistro((int) key);
                    }
                    break;
                case 7:
                    if (page > 1) {page--;}
                    break;
                case 8:
                    if (page < 4) {page++;}
                    break;
                case 9:
                    limpar();
                    break;
                case 10:
                    desordenador();
                    dasChamas.atualizarPosi();
                    limpar();
                    break;
                case 11:
                    verificador();
                    break;
                case 12:
                    inte1.ord1();
                    dasChamas.atualizarPosi();
                    limpar();
                    break;
                case 13:
                    inte2.ord1();
                    dasChamas.atualizarPosi();
                    limpar();
                    break;
                case 14:
                    dasChamas.printandoBuck();
                    break;
                case 15:// localiza id pelo hash
                    System.out.print("\nInsira o identificador ID da linha: ");
                    cr.printaSelecao(dasChamas.localizar(sc_man.nextInt()));
                    break;
                case 16:// listaInvertida
                    invetes.encontroInvertido(); // Exemplo: North Sea - Army - Caproni Ca.48
                    break;
                case 86:
                    case86();
                    break;
                default:
                    if (key != 0) {
                        System.out.println("Comando '" + key + "' desconhecido");
                    }
                    break;
            }
            //key = 11;
        } while (key != 0);
        try {
            // Limpa a tela no windows, no linux e no MacOS
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "color 07").inheritIO().start().waitFor();
            }
        } catch (InterruptedException | IOException e) {
            // Todo Auto-generated catch block
            System.out.println("Saida main:;");
            e.printStackTrace();
        }
        //limpar();
        System.out.println(": Programa Finalizado!");
        sc_man.close();
    }

    public static void menu(int page) {
        if (page == 1) {

            System.out.println(" -Operacoes do menu-----------------------------------------------------------");
            System.out.println(md1 + "Menu:       " + info);
            System.out.println("|                                      |                                      |");
            System.out.println("| 10: Desordenar arquivo               | 1: Puxa o csv e transforma em db     |");
            System.out.println("| 11: Verificar se está ordenado       | 2: Printa o arquivo no console       |");
            System.out.println("| 86: Altera modo teste/desenvolvedor  | 0: Sai do programa                   |");
            System.out.println("| 9: Limpa a tela                      |                                      |");
            System.out.println("|                                      | 8: Proxima pagina                  1 |");
            System.out.println(" -----------------------------------------------------------------------------");
            System.out.print(": ");
        }else if (page == 2) {
            
            System.out.println(" -Operacoes de Crud-----------------------------------------------------------");
            System.out.println(md1 + "Menu:       " + info);
            System.out.println("|                                      |                                      |");
            System.out.println("| 3: Cria uma nova linha;              | 6: Atualizar registro                |");
            System.out.println("| 4: Encontrar pelo Id (sequencial)    |                                      |");
            System.out.println("| 5: Deletar por Id                    |                                      |");
            System.out.println("|                                      |                                      |");
            System.out.println("| 7: Pagina anterior                   | 8: Proxima pagina                  2 |");
            System.out.println(" -----------------------------------------------------------------------------");
            System.out.print(": ");
        }else if (page == 3) {
            
            System.out.println(" -Operacoes de intercalar-----------------------------------------------------");
            System.out.println(md1 + "Menu:       " + info);
            System.out.println("|                                      |                                      |");
            System.out.println("| 12: Ordernar po Intercalacao-1;      |                                      |");
            System.out.println("| 13: Ordernar po Intercalacao-dinamica|                                      |");
            System.out.println("|                                      |                                      |");
            System.out.println("|                                      |                                      |");
            System.out.println("| 7: Pagina anterior                   | 8: Proxima pagina                  3 |");
            System.out.println(" -----------------------------------------------------------------------------");
            System.out.print(": ");
        }else if (page == 4) {
            
            System.out.println(" -Operacoes de Hash e lista invertida-----------------------------------------");
            System.out.println(md1 + "Menu:       " + info);
            System.out.println("|                                      |                                      |");
            System.out.println("| 14: Mostra todos os buckets          | 16 Encontar pela lista invertida     |");
            System.out.println("| 15: Localizar pelo id no hash        |                                      |");
            System.out.println("|                                      |                                      |");
            System.out.println("|                                      |                                      |");
            System.out.println("| 7: Pagina anterior                   |                                    4 |");
            System.out.println(" -----------------------------------------------------------------------------");
            System.out.print(": ");
        }
    }

    public static boolean verificador() {
        Airplane_Crashes arrayAC[];
        Airplane_Crashes ac = new Airplane_Crashes();
        Airplane_Crashes acVer = new Airplane_Crashes();
        byte[] ba;
        String aux = "";
        char c = ' ';
        int tam = 0;
        byte[] bayLei;

        boolean F = false;

        RandomAccessFile ler;
        try {

            System.out.println("\n "+ md3 +" \n");
            ler = new RandomAccessFile(md3, "rw");

            System.out.println("Ultimo registro: " + ler.readInt());
            c = ler.readChar();
            tam = ler.readInt();
            bayLei = new byte[tam];
            ler.read(bayLei);
            aux = ac.fromByteArray(bayLei);
            c = ler.readChar();
            System.out.println("Primeiro registro: " + aux);
            
            while (c != '@') {
                if (acVer != null && acVer.ID_ac != 0 && acVer.ID_ac > ac.ID_ac) {
                        System.out.println("Desordenado em: " + aux);
                        break;
                }
                acVer = ac.clonagem();

                tam = ler.readInt();
                bayLei = new byte[tam];
                ler.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = ler.readChar();
            }
            if (c == '@') {
                System.out.println("Arquivo ordenado");
                F = true;
            }
            ler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return F;
        //ord1();
    }

    public static void desordenador() {
        Airplane_Crashes ac = new Airplane_Crashes();
        RandomAccessFile arq;

        char c;
        int tam = 0;
        byte[] bayLei;
        String aux;

        int indexx = 0;
        long seek = 0;

        try {
            arq = new RandomAccessFile(md3, "rw");

            indexx = arq.readInt();
            c = arq.readChar();

            if (md3.equals("./dbs/jj.db")) {

                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(5);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(28);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(10);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(40);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(35);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(7);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(12);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(2);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(21);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(11);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(29);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(27);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(9);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(38);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(8);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(49);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(3);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(15);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(13);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(30);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(17);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(46);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(18);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(36);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(1);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(4);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(34);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(16);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(19);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(22);
                arq.seek(seek);

                tam = arq.readInt();
                bayLei = new byte[tam];
                arq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = arq.readChar();
                seek = arq.getFilePointer();// grava primeira posicao
                tam = arq.readInt();
                arq.writeInt(20);
                arq.seek(seek);
            } else {
                while (c != '@') {
                    if (c != '@') {
                        seek = arq.getFilePointer();// grava primeira posicao
                        tam = arq.readInt();
                        arq.writeInt(indexx);
                        indexx--;
                        arq.seek(seek);

                        tam = arq.readInt();
                        bayLei = new byte[tam];
                        arq.read(bayLei);
                        aux = ac.fromByteArray(bayLei);
                        c = arq.readChar(); // pula para a proxima posicao
                    }
                }
            }
            arq.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static Airplane_Crashes[] sort(Airplane_Crashes arrAc[]) {
        sortuda eu = new sortuda();
        Airplane_Crashes aux[] = new Airplane_Crashes[100];
        try {
            for (int i = 0; i < arrAc.length && arrAc[i] != null; i++) {
                eu = eu.inserir(arrAc[i], eu);
            }

            aux = eu.caminharCentral(eu, aux);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return aux;
    }

    public static void test(String ar) { // apenas para testes
        Airplane_Crashes arrayAC[];
        Airplane_Crashes ac = new Airplane_Crashes();
        byte[] ba;
        String aux = "";
        char c = ' ';
        int tam = 0;
        byte[] bayLei;

        RandomAccessFile ler;
        RandomAccessFile escrev;
        try {
            Scanner sc_tst2 = new Scanner(System.in);
            int b = 0;

            System.out.println("\n "+ ar +" \n");
            ler = new RandomAccessFile(ar, "rw");
            escrev = new RandomAccessFile("dbs/st.db", "rw");

            System.out.println("test= " + ler.readInt());
            c = ler.readChar();
            while (c != '@') {
                tam = ler.readInt();
                bayLei = new byte[tam];
                ler.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                escrev.writeUTF(ac.ID_ac + "; ");
                System.out.println(aux);
                if (b == 3) {
                    sc_tst2.nextLine();
                }
                c = ler.readChar();
                b++;
            }
            ler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int oCont(String ar) { // Conta total de arquivos
        Airplane_Crashes arrayAC[];
        int paraContar = 0;
        Airplane_Crashes ac = new Airplane_Crashes();
        byte[] ba;
        String aux = "";
        char c = ' ';
        int tam = 0;
        byte[] bayLei;

        RandomAccessFile ler;
        try {
            //System.out.println("\n "+ ar +" \n");
            ler = new RandomAccessFile(ar, "rw");

            ler.readInt();
            c = ler.readChar();
            while (c != '@') {
                tam = ler.readInt();
                bayLei = new byte[tam];
                ler.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                c = ler.readChar();
                paraContar++;
            }
            ler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paraContar;
    }

    public static void deletArqTempa(int chave) {
        FileOutputStream dis;
        DataOutputStream dos;

        switch (chave) {
            case 0:
                try {
                    dis = new FileOutputStream("dbs/q1.db"); // Cria ou zera os arquivos temporarios
                    dos = new DataOutputStream(dis);
                    dos.writeChar('@');
                    dos.close();
                    dis.close();

                    dis = new FileOutputStream("dbs/q2.db");
                    dos = new DataOutputStream(dis);
                    dos.writeChar('@');
                    dos.close();
                    dis.close();

                    dis = new FileOutputStream("dbs/q3.db");
                    dos = new DataOutputStream(dis);
                    dos.writeChar('@');
                    dos.close();
                    dis.close();

                    dis = new FileOutputStream("dbs/q4.db");
                    dos = new DataOutputStream(dis);
                    dos.writeChar('@');
                    dos.close();
                    dis.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                break;

            case 1:
                try {
                    dis = new FileOutputStream("dbs/q1.db"); // Cria ou zera os arquivos temporarios
                    dos = new DataOutputStream(dis);
                    dos.writeChar('@');
                    dos.close();
                    dis.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                break;

            case 2:
                try {
                    dis = new FileOutputStream("dbs/q2.db"); // Cria ou zera os arquivos temporarios
                    dos = new DataOutputStream(dis);
                    dos.writeChar('@');
                    dos.close();
                    dis.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                break;

            case 3:
                try {
                    dis = new FileOutputStream("dbs/q3.db"); // Cria ou zera os arquivos temporarios
                    dos = new DataOutputStream(dis);
                    dos.writeChar('@');
                    dos.close();
                    dis.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                break;

            case 4:
                try {
                    dis = new FileOutputStream("dbs/q4.db"); // Cria ou zera os arquivos temporarios
                    dos = new DataOutputStream(dis);
                    dos.writeChar('@');
                    dos.close();
                    dis.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                break;
            case 5:
                try {
                    dis = new FileOutputStream("dbs/arvb.db"); // Cria ou zera os arquivos temporarios
                    dos = new DataOutputStream(dis);
                    dos.writeChar('0');
                    dos.close();
                    dis.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                break;

            default:
                break;
        }
    }

    public static void case86() {
        if (md3 == "./dbs/jj.db") {
            md1 = "|       Modo Desenvolvedor           ";
            md2 = "./csv/Airplanev5_1.csv";
            md3 = "./dbs/j2.db";

            try {
                // Limpa a tela no windows, no linux e no MacOS
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "color 0c").inheritIO().start().waitFor();
                }
            } catch (InterruptedException | IOException e) {
                // Todo Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            if (md3 == "./dbs/j2.db") {
                md1 = "|       Modo Tester                  ";
                md2 = "./csv/Airplanev5_2.csv";
                md3 = "./dbs/jj.db";

                try {
                    // Limpa a tela no windows, no linux e no MacOS
                    if (System.getProperty("os.name").contains("Windows")) {
                        new ProcessBuilder("cmd", "/c", "color 07").inheritIO().start().waitFor();
                    }
                } catch (InterruptedException | IOException e) {
                    // Todo Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void lerdb(byte leitura) { // Apenas printa o arquivo dbs/jj.db no console;
        RandomAccessFile arqR2;
        Airplane_Crashes ac = new Airplane_Crashes();

        int ult_posi = 0;
        String aux = "";
        byte[] ba;
        int len;
        char R_I_P = '0';

        try {
            arqR2 = new RandomAccessFile(md3, "rw");
            ult_posi = arqR2.readInt();

            while (R_I_P != '@') { // mostra todos os arquivos
                R_I_P = arqR2.readChar();
                if (R_I_P == '=') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                    aux = ac.fromByteArray(ba);
                    System.out.println(aux);
                } else if (R_I_P == '*') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                } else if(R_I_P == '@'){}
            }
            arqR2.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " = Fim " + ult_posi);
        }
    }

    public static void limpar() {
        try {
            // Limpa a tela no windows, no linux e no MacOS
            if (System.getProperty("os.name").contains("Windows")) {

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (InterruptedException | IOException e) {
            // Todo Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void CsvForDb() { // puxa o csv e transforma em db
        Airplane_Crashes AC = new Airplane_Crashes();
        hashira dasChamas = new hashira();
        dasChamas.incialBuckt();
        dasChamas.iniciarIndex();
        //arvB arB = new arvB();

        FileOutputStream arq; // arquivo de saída
        DataOutputStream dos;// fluxo de saída de dados
        RandomAccessFile arando;
        int id = 1;         // nomeia cada registro com um id ------------------------ 2.147.473.647 int/int 32.767
        int ult = 0;

        long forB = 0;

        File file = new File(md2);
        Scanner sc = null;

        byte[] ba;
        //int len;

        RandomAccessFile rad;
        deletArqTempa(5);

        try {
            rad = new RandomAccessFile("dbs/arvB.db", "rw"); // inicializacao do arquivo arv b
            rad.writeLong(-1);
            rad.close();

            arq = new FileOutputStream(md3);
            dos = new DataOutputStream(arq);

            sc = new Scanner(file);
            String line = sc.nextLine();
            dos.writeInt(id); 
            dos.close();
            arq.close();

            arando = new RandomAccessFile(md3, "rw");
            arando.writeInt(id);

            while (sc.hasNextLine()) {
                line = sc.nextLine(); // Le a proxima linha no csv
                //ult = arando.getFilePointer();
                AC.SeparaValores(line); // separar valores

                forB = arando.getFilePointer();
                arando.writeChar('=');    // Lapide / Byte da morte / R_I_P
                ult = id;
                ba = AC.toByteArray(id);

                

                id++;
                arando.writeInt(ba.length); //Tamano do registro em bytes
                arando.write(ba);

                System.out.println(ult);
                dasChamas.inserir(ult, forB);
                
                //arB.insercao(ult, forB);  // Insere na arvore B
                //AC = new Airplane_Crashes();
            }
            arando.writeChar('@'); // fim do arquivo
            arando.seek(0);
            arando.writeInt(ult);

            arando.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        info = "O csv foi salvo              |";
    }
}

class intercalar2{
        
    public void ord1() {
        Airplane_Crashes arrayAC[];
        Airplane_Crashes ac = new Airplane_Crashes();
        byte[] ba;
        String aux = "";
        char c = ' ';
        int tam = 0;
        byte[] bayLei;

        while (tp1.verificador() == false) {

            tp1.deletArqTempa(0); // Cria ou zera os arquivos temporarios

            entregaDeValor(); // etapa 1
            System.out.println("Etapa 1: Comcluida");

            intercalar(); // etapa 2
            System.out.println("Etapa 2: Comcluida");

            tp1.deletArqTempa(1); // Cria ou zera o arquivo temporario dbs/q1.db
            tp1.deletArqTempa(2); // Cria ou zera o arquivo temporario dbs/q2.db

            intercalacao2(); // etapa 3 (separa os arq's 3 e 4 na metade e os intercala
                            // retornando aos arq's 1 e 2)
            System.out.println("Etapa 3: Comcluida");

            tp1.deletArqTempa(3); // Cria ou zera o arquivo temporario dbs/q3.db
            tp1.deletArqTempa(4); // Cria ou zera o arquivo temporario dbs/q4.db

            intercalar3(); // etapa 4
            System.out.println("Etapa 4: Comcluida");
            //tp1.limpar();
        }
    }
    
    public void intercalar3() { // entapa 4
        RandomAccessFile arq1;
        RandomAccessFile arq2;
        Airplane_Crashes ac1 = new Airplane_Crashes();
        Airplane_Crashes ac2 = new Airplane_Crashes();
        char c1;
        char c2;
        int tam1;
        int tam2;
        byte[] bayLei1;
        byte[] bayLei2;
        String aux;
        String arqN = tp1.md3;

        long ult3 = 0; // Marca a ultima posicao do arq3
        long ult4 = 0; // Marca a ultima posicao do arq4
        long ultAux = 0; // Auxilia o uso
        //                                              (posicao == ultimo byte do arquivo) marcado por um '@'

        int contAc1 = 0; // contador de registros
        int contAc2 = 0;

        try {
            arq1 = new RandomAccessFile("dbs/q1.db", "rw");
            arq2 = new RandomAccessFile("dbs/q2.db", "rw");

            arq1.readInt();
            int resg = arq2.readInt();

            c1 = arq1.readChar(); // Prepara o primeiro registro para cada um dos 2 arquivos: arq1 / arq2
            c2 = arq2.readChar();

            if (c1 != '@') {
                tam1 = arq1.readInt();
                bayLei1 = new byte[tam1];
                arq1.read(bayLei1);
                aux = ac1.fromByteArray(bayLei1);
            }

            if (c1 != '@') {
                tam2 = arq2.readInt();
                bayLei2 = new byte[tam2];
                arq2.read(bayLei2);
                aux = ac2.fromByteArray(bayLei2);
            }

            while (c1 != '@' || c2 != '@') {
                //System.out.println("3-Fora I");
                if (ac1.ID_ac < ac2.ID_ac && c1 != '@') { // intercalacao propriamente dita

                    ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                    c1 = arq1.readChar(); // avança para o proximo registro
                    contAc1++;

                    if (c1 != '@') {
                        tam1 = arq1.readInt();
                        bayLei1 = new byte[tam1];
                        arq1.read(bayLei1);
                        aux = ac1.fromByteArray(bayLei1);
                    }
                } else if (c2 != '@') {

                    ultAux = gravUM(ac2, ultAux, arqN); // Grava o objeto em dbs/q3.db
                    c2 = arq2.readChar(); // avança para o proximo registro
                    contAc1++;

                    if (c2 != '@') {
                        tam2 = arq2.readInt();
                        bayLei2 = new byte[tam2];
                        arq2.read(bayLei2);
                        aux = ac2.fromByteArray(bayLei2);
                    }
                } else if (ac1.ID_ac > ac2.ID_ac && c1 != '@') {
                    ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                    c1 = arq1.readChar(); // avança para o proximo registro
                    contAc1++;

                    if (c1 != '@') {
                        tam1 = arq1.readInt();
                        bayLei1 = new byte[tam1];
                        arq1.read(bayLei1);
                        aux = ac1.fromByteArray(bayLei1);
                    }
                }
            }

            arq2.close();
            arq1.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void intercalacao2(){ // entapa 3
        RandomAccessFile arq3;
        RandomAccessFile arq4;
        Airplane_Crashes ac1 = new Airplane_Crashes();
        Airplane_Crashes ac2 = new Airplane_Crashes();
        char c1;
        char c2;
        int tam1;
        int tam2;
        byte[] bayLei1;
        byte[] bayLei2;
        String aux;
        String arqN = "dbs/q1.db";

        int TamID1 = tp1.oCont("dbs/q3.db");  // Tamnho do registro
        int TamID2 = tp1.oCont("dbs/q4.db"); // Tamnho do registro

        long ult1 = 0;     // Marca a ultima posicao do arq1
        long ult2 = 0;    // Marca a ultima posicao do arq2
        long ultAux = 0; // Auxilia o uso
                        //                 (posicao == ultimo byte do arquivo) marcado por um '@'

        int contAc1 = 0; // contador de registros
        int contAc2 = 0;

        int metadeDoArq = 0;

        try {
            arq3 = new RandomAccessFile("dbs/q3.db", "rw");
            arq4 = new RandomAccessFile("dbs/q4.db", "rw");

            arq3.readInt();
            arq4.readInt();

            c1 = arq3.readChar(); // Prepara o primeiro registro para cada um dos 2 arquivos: arq3 / arq4
            c2 = arq4.readChar();
            tam1 = arq3.readInt();
            bayLei1 = new byte[tam1];
            arq3.read(bayLei1);
            aux = ac1.fromByteArray(bayLei1);
            tam2 = arq4.readInt();
            bayLei2 = new byte[tam2];
            arq4.read(bayLei2);
            aux = ac2.fromByteArray(bayLei2);

            if (TamID1 >= TamID2) {
                metadeDoArq = TamID1/2;
            } else {
                metadeDoArq = TamID2/2;
            }

            while (c1 != '@' || c2 != '@') {
                System.out.println("2-Fora I");
                while ((contAc1 < metadeDoArq || contAc2 < metadeDoArq) && (c1 != '@' || c2 != '@')) {
                    if (ac1.ID_ac < ac2.ID_ac && contAc1 < metadeDoArq && c1 != '@') { // intercalacao propriamente dita

                        
                        //System.out.print(contAc1 + "-A; ");

                        ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                        c1 = arq3.readChar(); // avança para o proximo registro
                        contAc1++;

                        if (c1 != '@') {
                            tam1 = arq3.readInt();
                            bayLei1 = new byte[tam1];
                            arq3.read(bayLei1);
                            aux = ac1.fromByteArray(bayLei1);
                        }
                    } else if (contAc2 < metadeDoArq && c2 != '@') { //ac1.ID_ac > ac2.ID_ac

                        
                        //System.out.print(contAc2 + "-B; ");

                        ultAux = gravUM(ac2, ultAux, arqN); // Grava o objeto em dbs/q3.db
                        c2 = arq4.readChar(); // avança para o proximo registro
                        contAc2++;

                        if (c2 != '@') {
                            tam2 = arq4.readInt();
                            bayLei2 = new byte[tam2];
                            arq4.read(bayLei2);
                            aux = ac2.fromByteArray(bayLei2);
                        }
                    } else if (ac1.ID_ac > ac2.ID_ac && contAc1 < metadeDoArq && c1 != '@') {
                        ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                        c1 = arq3.readChar(); // avança para o proximo registro
                        contAc1++;

                        if (c1 != '@') {
                            tam1 = arq3.readInt();
                            bayLei1 = new byte[tam1];
                            arq3.read(bayLei1);
                            aux = ac1.fromByteArray(bayLei1);
                        }
                    }
                    else {
                        System.out.println("saida estrategica do lupe");
                        contAc1 = metadeDoArq; // saida estrategica do lupe
                        contAc2 = metadeDoArq;
                    }
                }
                contAc1 = 0;
                contAc2 = 0;
                if (arqN.equals("dbs/q1.db")) {
                    ult1 = ultAux;
                    ultAux = ult2;
                    arqN = "dbs/q2.db";
                    System.out.println("Trca de posi");
                }else{
                    ult2 = ultAux;
                    ultAux = ult1;
                    arqN = "dbs/q1.db";
                }
                System.out.println("2-Fora F");
            }

            arq4.close();
            arq3.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void entregaDeValor() { // entapa 1
        RandomAccessFile arqR2;
        Airplane_Crashes ac = new Airplane_Crashes();
        Airplane_Crashes arrayAC[] = new Airplane_Crashes[100];

        int ult_posi = 0;
        String aux = "";
        byte[] ba;
        int len;
        char R_I_P = '0';
        int errCal = 0;

        long ultArq1 = 0;
        long ultArq2 = 0;

        boolean alternado = false;

        if (tp1.md3.equals("./dbs/jj.db")) {
            tp1.limitMemory = 4;
        }else{
            tp1.limitMemory = 100;
        }

        try {
            arqR2 = new RandomAccessFile(tp1.md3, "rw");
            ult_posi = arqR2.readInt();

            // while (sc.hasNextLine()) {

            for (int i = 0; R_I_P != '@'; i++) {
                R_I_P = arqR2.readChar();
                
                if (i >= tp1.limitMemory + errCal || R_I_P == '@') {
                    if (alternado == false) {
                        ultArq1 = gravX(tp1.sort(arrayAC), ultArq1, "dbs/q1.db");
                        alternado = true;
                    } else if(alternado == true){
                        ultArq2 = gravX(tp1.sort(arrayAC), ultArq2, "dbs/q2.db");
                        alternado = false;
                    }
                    arrayAC = new Airplane_Crashes[tp1.limitMemory];
                    i = 0;
                    errCal = 0;
                } if (R_I_P == '=') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                    aux = ac.fromByteArray(ba);
                    arrayAC[i - errCal] = ac.clonagem();
                } else if (R_I_P == '*') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                    errCal++;
                }
            }

            arqR2.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " = Fim " + ult_posi);
        }
    }

    public void intercalar() { // entapa 2=
        RandomAccessFile arq1;
        RandomAccessFile arq2;
        Airplane_Crashes ac1 = new Airplane_Crashes();
        Airplane_Crashes ac2 = new Airplane_Crashes();
        char c1;
        char c2;
        int tam1;
        int tam2;
        byte[] bayLei1;
        byte[] bayLei2;
        String aux;
        String arqN = "dbs/q3.db";

        int antgValor1 = 0;
        int antgValor2 = 0;

        long ult3 = 0; // Marca a ultima posicao do arq3
        long ult4 = 0; // Marca a ultima posicao do arq4
        long ultAux = 0; // Auxilia o uso
        //                                              (posicao == ultimo byte do arquivo) marcado por um '@'

        int contAc1 = 0; // contador de registros
        int contAc2 = 0;

        try {
            arq1 = new RandomAccessFile("dbs/q1.db", "rw");
            arq2 = new RandomAccessFile("dbs/q2.db", "rw");

            arq1.readInt();
            arq2.readInt();

            c1 = arq1.readChar();  // Prepara o primeiro registro para cada um dos 2 arquivos: arq1 / arq2
            c2 = arq2.readChar();

            tam1 = arq1.readInt();
            bayLei1 = new byte[tam1];
            arq1.read(bayLei1);
            aux = ac1.fromByteArray(bayLei1);

            tam2 = arq2.readInt();
            bayLei2 = new byte[tam2];
            arq2.read(bayLei2);
            aux = ac2.fromByteArray(bayLei2);

            boolean condicional = true;

            while (c1 != '@' || c2 != '@') {
                while ((contAc1 <= tp1.limitMemory || contAc2 <= tp1.limitMemory) && (c1 != '@' || c2 != '@')) {
                    if (ac1.ID_ac < ac2.ID_ac && contAc1 < tp1.limitMemory && c1 != '@') { // intercalacao propriamente dita

                        // System.out.print(contAc1 + "-A; ");

                        ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                        antgValor1 = ac1.ID_ac;
                        c1 = arq1.readChar(); // avança para o proximo registro
                        contAc1++;

                        if (c1 != '@') {
                            tam1 = arq1.readInt();
                            bayLei1 = new byte[tam1];
                            arq1.read(bayLei1);
                            aux = ac1.fromByteArray(bayLei1);
                            //System.out.println(aux);
                        }
                        //System.out.println("Aaux");
                    } else if (contAc2 < tp1.limitMemory && c2 != '@') { // ac1.ID_ac > ac2.ID_ac

                        // System.out.print(contAc2 + "-B; ");

                        ultAux = gravUM(ac2, ultAux, arqN); // Grava o objeto em dbs/q1.db
                        antgValor2 = ac2.ID_ac;
                        c2 = arq2.readChar(); // avança para o proximo registro
                        contAc2++;

                        if (c2 != '@') {
                            tam2 = arq2.readInt();
                            bayLei2 = new byte[tam2];
                            arq2.read(bayLei2);
                            aux = ac2.fromByteArray(bayLei2);
                            //System.out.println(aux);
                        }
                        //System.out.println("Baux");
                    } else if (ac1.ID_ac > ac2.ID_ac && contAc1 < tp1.limitMemory && c1 != '@') {
                        ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q1.db
                        antgValor1 = ac1.ID_ac;
                        c1 = arq1.readChar(); // avança para o proximo registro
                        contAc1++;

                        if (c1 != '@') {
                            tam1 = arq1.readInt();
                            bayLei1 = new byte[tam1];
                            arq1.read(bayLei1);
                            aux = ac1.fromByteArray(bayLei1);
                            //System.out.println(aux);
                            
                        }
                        //System.out.println("A2aux");
                    } else {
                        if (c1 == '@' && c2 == '@') {
                            contAc1 = tp1.limitMemory+1; // saida estrategica do lupe
                            contAc2 = tp1.limitMemory+1;
                        }else{
                            
                            if (antgValor1 < ac1.ID_ac && condicional == true) {
                                System.out.println("Continuebas: 1 :");
                                contAc1 = 0;
                                condicional = false;
                            }else if (antgValor2 < ac2.ID_ac && condicional == true) {
                                System.out.println("Continuebas: 2 :");
                                contAc2 = 0;
                                condicional = false;
                            }
                            if((contAc1 >= tp1.limitMemory || c1 == '@') && (contAc2 >= tp1.limitMemory || c2 == '@')){
                                break;
                            }
                        }

                    }
                }
                condicional = true;
                contAc1 = 0;
                contAc2 = 0;
                if (arqN.equals("dbs/q3.db")) {
                    ult3 = ultAux;
                    ultAux = ult4;
                    arqN = "dbs/q4.db";
                } else {
                    ult4 = ultAux;
                    ultAux = ult3;
                    arqN = "dbs/q3.db";
                }
            }

            arq2.close();
            arq1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n ac1= " + ac1.ID_ac + "\n ac2= " + ac2.ID_ac);
        }
    }

    public long gravUM(Airplane_Crashes AC, long ult, String aquivo) { //OK
        Airplane_Crashes ac = new Airplane_Crashes();
        byte[] ba;
        String aux = "";
        char c = ' ';
        int tam = 0;
        byte[] bayLei;

        RandomAccessFile aq;

        try {
            aq = new RandomAccessFile(aquivo, "rw");// "dbs/q3.db"

            if (ult == 0) {
                aq.writeInt(AC.ID_ac);
            }else{
                aq.writeInt(AC.ID_ac);
                aq.seek(ult);
            }

            ba = AC.toByteArray((int) 0);
            aux = AC.fromByteArray(ba);
            aq.writeChar('=');
            aq.writeInt(ba.length);
            aq.write(ba);

            ult = aq.getFilePointer();
            aq.writeChar('@');

            aq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ult;
    }

    public long gravX(Airplane_Crashes arrayAC[], long ult, String aquivo) { // OK
        Airplane_Crashes ac = new Airplane_Crashes();
        byte[] ba;
        String aux = "";
        char c = ' ';
        int tam = 0;
        byte[] bayLei;

        RandomAccessFile aq;

        try {
            aq = new RandomAccessFile(aquivo, "rw");//"dbs/q3.db"

            if (ult == 0) {
                aq.writeInt(1);
            }else{
                aq.seek(ult);
            }

            for (int i = 0; i < arrayAC.length && arrayAC[i] != null; i++) {
                ba = arrayAC[i].toByteArray((int) 0);
                aux = arrayAC[i].fromByteArray(ba);
                aq.writeChar('=');
                aq.writeInt(ba.length);
                aq.write(ba);
                ac = arrayAC[i];
            }
            ult = aq.getFilePointer();
            aq.writeChar('@');
            aq.seek(0);
            aq.writeInt(ac.ID_ac);

            aq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ult;
    }

}

class intercar1{
    
    public void ord1() {
        Airplane_Crashes arrayAC[];
        Airplane_Crashes ac = new Airplane_Crashes();
        byte[] ba;
        String aux = "";
        char c = ' ';
        int tam = 0;
        byte[] bayLei;

        while (tp1.verificador() == false) {

            tp1.deletArqTempa(0); // Cria ou zera os arquivos temporarios

            entregaDeValor(); // etapa 1
            System.out.println("Etapa 1: Comcluida");

            intercalar(); // etapa 2
            System.out.println("Etapa 2: Comcluida");

            tp1.deletArqTempa(1); // Cria ou zera o arquivo temporario dbs/q1.db
            tp1.deletArqTempa(2); // Cria ou zera o arquivo temporario dbs/q2.db

            intercalacao2(); // etapa 3 (separa os arq's 3 e 4 na metade e os intercala
                            // retornando aos arq's 1 e 2)
            System.out.println("Etapa 3: Comcluida");

            tp1.deletArqTempa(3); // Cria ou zera o arquivo temporario dbs/q3.db
            tp1.deletArqTempa(4); // Cria ou zera o arquivo temporario dbs/q4.db

            intercalar3(); // etapa 4
            System.out.println("Etapa 4: Comcluida");
            //tp1.limpar();
        }
/*
        RandomAccessFile aq;
        int inutiu = 0;

        try {
            System.out.println("\n -dbs/q3.db- \n");
            aq = new RandomAccessFile(md3, "rw");
            Scanner sc_tst = new Scanner(System.in);

            System.out.println(aq.readInt());
            c = aq.readChar();
            while (c != '@') {
                tam = aq.readInt();
                bayLei = new byte[tam];
                aq.read(bayLei);
                aux = ac.fromByteArray(bayLei);
                System.out.println(aux);
                inutiu++;
                if (inutiu == 10) {
                    inutiu = 0;
                    sc_tst.nextLine();
                    System.out.println("===================================================");
                }

                c = aq.readChar();
            }
            aq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }
    
    public void intercalar3() { // entapa 4
        RandomAccessFile arq1;
        RandomAccessFile arq2;
        Airplane_Crashes ac1 = new Airplane_Crashes();
        Airplane_Crashes ac2 = new Airplane_Crashes();
        char c1;
        char c2;
        int tam1;
        int tam2;
        byte[] bayLei1;
        byte[] bayLei2;
        String aux;
        String arqN = tp1.md3;

        long ult3 = 0; // Marca a ultima posicao do arq3
        long ult4 = 0; // Marca a ultima posicao do arq4
        long ultAux = 0; // Auxilia o uso
        //                                              (posicao == ultimo byte do arquivo) marcado por um '@'

        int contAc1 = 0; // contador de registros
        int contAc2 = 0;

        try {
            arq1 = new RandomAccessFile("dbs/q1.db", "rw");
            arq2 = new RandomAccessFile("dbs/q2.db", "rw");

            arq1.readInt();
            int resg = arq2.readInt();

            c1 = arq1.readChar(); // Prepara o primeiro registro para cada um dos 2 arquivos: arq1 / arq2
            c2 = arq2.readChar();

            if (c1 != '@') {
                tam1 = arq1.readInt();
                bayLei1 = new byte[tam1];
                arq1.read(bayLei1);
                aux = ac1.fromByteArray(bayLei1);
            }

            if (c1 != '@') {
                tam2 = arq2.readInt();
                bayLei2 = new byte[tam2];
                arq2.read(bayLei2);
                aux = ac2.fromByteArray(bayLei2);
            }

            while (c1 != '@' || c2 != '@') {
                //System.out.println("3-Fora I");
                if (ac1.ID_ac < ac2.ID_ac && c1 != '@') { // intercalacao propriamente dita

                    ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                    c1 = arq1.readChar(); // avança para o proximo registro
                    contAc1++;

                    if (c1 != '@') {
                        tam1 = arq1.readInt();
                        bayLei1 = new byte[tam1];
                        arq1.read(bayLei1);
                        aux = ac1.fromByteArray(bayLei1);
                    }
                } else if (c2 != '@') {

                    ultAux = gravUM(ac2, ultAux, arqN); // Grava o objeto em dbs/q3.db
                    c2 = arq2.readChar(); // avança para o proximo registro
                    contAc1++;

                    if (c2 != '@') {
                        tam2 = arq2.readInt();
                        bayLei2 = new byte[tam2];
                        arq2.read(bayLei2);
                        aux = ac2.fromByteArray(bayLei2);
                    }
                } else if (ac1.ID_ac > ac2.ID_ac && c1 != '@') {
                    ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                    c1 = arq1.readChar(); // avança para o proximo registro
                    contAc1++;

                    if (c1 != '@') {
                        tam1 = arq1.readInt();
                        bayLei1 = new byte[tam1];
                        arq1.read(bayLei1);
                        aux = ac1.fromByteArray(bayLei1);
                    }
                }
            }

            arq2.close();
            arq1.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void intercalacao2(){ // entapa 3
        RandomAccessFile arq3;
        RandomAccessFile arq4;
        Airplane_Crashes ac1 = new Airplane_Crashes();
        Airplane_Crashes ac2 = new Airplane_Crashes();
        char c1;
        char c2;
        int tam1;
        int tam2;
        byte[] bayLei1;
        byte[] bayLei2;
        String aux;
        String arqN = "dbs/q1.db";

        int TamID1 = tp1.oCont("dbs/q3.db");  // Tamnho do registro
        int TamID2 = tp1.oCont("dbs/q4.db"); // Tamnho do registro

        long ult1 = 0;     // Marca a ultima posicao do arq1
        long ult2 = 0;    // Marca a ultima posicao do arq2
        long ultAux = 0; // Auxilia o uso
                        //                 (posicao == ultimo byte do arquivo) marcado por um '@'

        int contAc1 = 0; // contador de registros
        int contAc2 = 0;

        int metadeDoArq = 0;

        try {
            arq3 = new RandomAccessFile("dbs/q3.db", "rw");
            arq4 = new RandomAccessFile("dbs/q4.db", "rw");

            arq3.readInt();
            arq4.readInt();

            c1 = arq3.readChar(); // Prepara o primeiro registro para cada um dos 2 arquivos: arq3 / arq4
            c2 = arq4.readChar();
            tam1 = arq3.readInt();
            bayLei1 = new byte[tam1];
            arq3.read(bayLei1);
            aux = ac1.fromByteArray(bayLei1);
            tam2 = arq4.readInt();
            bayLei2 = new byte[tam2];
            arq4.read(bayLei2);
            aux = ac2.fromByteArray(bayLei2);

            if (TamID1 >= TamID2) {
                metadeDoArq = TamID1/2;
            } else {
                metadeDoArq = TamID2/2;
            }

            while (c1 != '@' || c2 != '@') {
                System.out.println("2-Fora I");
                while ((contAc1 < metadeDoArq || contAc2 < metadeDoArq) && (c1 != '@' || c2 != '@')) {
                    if (ac1.ID_ac < ac2.ID_ac && contAc1 < metadeDoArq && c1 != '@') { // intercalacao propriamente dita

                        
                        //System.out.print(contAc1 + "-A; ");

                        ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                        c1 = arq3.readChar(); // avança para o proximo registro
                        contAc1++;

                        if (c1 != '@') {
                            tam1 = arq3.readInt();
                            bayLei1 = new byte[tam1];
                            arq3.read(bayLei1);
                            aux = ac1.fromByteArray(bayLei1);
                        }
                    } else if (contAc2 < metadeDoArq && c2 != '@') { //ac1.ID_ac > ac2.ID_ac

                        
                        //System.out.print(contAc2 + "-B; ");

                        ultAux = gravUM(ac2, ultAux, arqN); // Grava o objeto em dbs/q3.db
                        c2 = arq4.readChar(); // avança para o proximo registro
                        contAc2++;

                        if (c2 != '@') {
                            tam2 = arq4.readInt();
                            bayLei2 = new byte[tam2];
                            arq4.read(bayLei2);
                            aux = ac2.fromByteArray(bayLei2);
                        }
                    } else if (ac1.ID_ac > ac2.ID_ac && contAc1 < metadeDoArq && c1 != '@') {
                        ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                        c1 = arq3.readChar(); // avança para o proximo registro
                        contAc1++;

                        if (c1 != '@') {
                            tam1 = arq3.readInt();
                            bayLei1 = new byte[tam1];
                            arq3.read(bayLei1);
                            aux = ac1.fromByteArray(bayLei1);
                        }
                    }
                    else {
                        System.out.println("saida estrategica do lupe");
                        contAc1 = metadeDoArq; // saida estrategica do lupe
                        contAc2 = metadeDoArq;
                    }
                }
                contAc1 = 0;
                contAc2 = 0;
                if (arqN.equals("dbs/q1.db")) {
                    ult1 = ultAux;
                    ultAux = ult2;
                    arqN = "dbs/q2.db";
                    System.out.println("Trca de posi");
                }else{
                    ult2 = ultAux;
                    ultAux = ult1;
                    arqN = "dbs/q1.db";
                }
                System.out.println("2-Fora F");
            }

            arq4.close();
            arq3.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void entregaDeValor() { // entapa 1
        RandomAccessFile arqR2;
        Airplane_Crashes ac = new Airplane_Crashes();
        Airplane_Crashes arrayAC[] = new Airplane_Crashes[100];

        int ult_posi = 0;
        String aux = "";
        byte[] ba;
        int len;
        char R_I_P = '0';
        int errCal = 0;

        long ultArq1 = 0;
        long ultArq2 = 0;

        boolean alternado = false;

        if (tp1.md3.equals("./dbs/jj.db")) {
            tp1.limitMemory = 4;
        }else{
            tp1.limitMemory = 100;
        }

        try {
            arqR2 = new RandomAccessFile(tp1.md3, "rw");
            ult_posi = arqR2.readInt();

            // while (sc.hasNextLine()) {

            for (int i = 0; R_I_P != '@'; i++) {
                R_I_P = arqR2.readChar();
                
                if (i >= tp1.limitMemory + errCal || R_I_P == '@') {
                    if (alternado == false) {
                        ultArq1 = gravX(tp1.sort(arrayAC), ultArq1, "dbs/q1.db");
                        alternado = true;
                    } else if(alternado == true){
                        ultArq2 = gravX(tp1.sort(arrayAC), ultArq2, "dbs/q2.db");
                        alternado = false;
                    }
                    arrayAC = new Airplane_Crashes[tp1.limitMemory];
                    i = 0;
                    errCal = 0;
                } if (R_I_P == '=') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                    aux = ac.fromByteArray(ba);
                    arrayAC[i - errCal] = ac.clonagem();
                } else if (R_I_P == '*') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                    errCal++;
                }
            }

            arqR2.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " = Fim " + ult_posi);
        }
    }

    public void intercalar() { // entapa 2
        RandomAccessFile arq1;
        RandomAccessFile arq2;
        Airplane_Crashes ac1 = new Airplane_Crashes();
        Airplane_Crashes ac2 = new Airplane_Crashes();
        char c1;
        char c2;
        int tam1;
        int tam2;
        byte[] bayLei1;
        byte[] bayLei2;
        String aux;
        String arqN = "dbs/q3.db";

        long ult3 = 0; // Marca a ultima posicao do arq3
        long ult4 = 0; // Marca a ultima posicao do arq4
        long ultAux = 0; // Auxilia o uso
        //                                              (posicao == ultimo byte do arquivo) marcado por um '@'

        int contAc1 = 0; // contador de registros
        int contAc2 = 0;

        try {
            arq1 = new RandomAccessFile("dbs/q1.db", "rw");
            arq2 = new RandomAccessFile("dbs/q2.db", "rw");

            arq1.readInt();
            arq2.readInt();

            c1 = arq1.readChar();  // Prepara o primeiro registro para cada um dos 2 arquivos: arq1 / arq2
            c2 = arq2.readChar();

            tam1 = arq1.readInt();
            bayLei1 = new byte[tam1];
            arq1.read(bayLei1);
            aux = ac1.fromByteArray(bayLei1);

            tam2 = arq2.readInt();
            bayLei2 = new byte[tam2];
            arq2.read(bayLei2);
            aux = ac2.fromByteArray(bayLei2);

            while (c1 != '@' || c2 != '@') {
                while ((contAc1 < tp1.limitMemory || contAc2 < tp1.limitMemory) && (c1 != '@' || c2 != '@')) {
                    if (ac1.ID_ac < ac2.ID_ac && contAc1 < tp1.limitMemory && c1 != '@') { // intercalacao propriamente dita

                        // System.out.print(contAc1 + "-A; ");

                        ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q3.db
                        c1 = arq1.readChar(); // avança para o proximo registro
                        contAc1++;

                        if (c1 != '@') {
                            tam1 = arq1.readInt();
                            bayLei1 = new byte[tam1];
                            arq1.read(bayLei1);
                            aux = ac1.fromByteArray(bayLei1);
                            //System.out.println(aux);
                        }
                        //System.out.println("Aaux");
                    } else if (contAc2 < tp1.limitMemory && c2 != '@') { // ac1.ID_ac > ac2.ID_ac

                        // System.out.print(contAc2 + "-B; ");

                        ultAux = gravUM(ac2, ultAux, arqN); // Grava o objeto em dbs/q1.db
                        c2 = arq2.readChar(); // avança para o proximo registro
                        contAc2++;

                        if (c2 != '@') {
                            tam2 = arq2.readInt();
                            bayLei2 = new byte[tam2];
                            arq2.read(bayLei2);
                            aux = ac2.fromByteArray(bayLei2);
                            //System.out.println(aux);
                        }
                        //System.out.println("Baux");
                    } else if (ac1.ID_ac > ac2.ID_ac && contAc1 < tp1.limitMemory && c1 != '@') {
                        ultAux = gravUM(ac1, ultAux, arqN); // Grava o objeto em dbs/q1.db
                        c1 = arq1.readChar(); // avança para o proximo registro
                        contAc1++;

                        if (c1 != '@') {
                            tam1 = arq1.readInt();
                            bayLei1 = new byte[tam1];
                            arq1.read(bayLei1);
                            aux = ac1.fromByteArray(bayLei1);
                            //System.out.println(aux);
                            
                        }
                        //System.out.println("A2aux");
                    } else {
                        contAc1 = tp1.limitMemory; // saida estrategica do lupe
                        contAc2 = tp1.limitMemory;
                    }
                }
                contAc1 = 0;
                contAc2 = 0;
                if (arqN.equals("dbs/q3.db")) {
                    ult3 = ultAux;
                    ultAux = ult4;
                    arqN = "dbs/q4.db";
                } else {
                    ult4 = ultAux;
                    ultAux = ult3;
                    arqN = "dbs/q3.db";
                }
            }

            arq2.close();
            arq1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n ac1= " + ac1.ID_ac + "\n ac2= " + ac2.ID_ac);
        }
    }

    public long gravUM(Airplane_Crashes AC, long ult, String aquivo) { //OK
        Airplane_Crashes ac = new Airplane_Crashes();
        byte[] ba;
        String aux = "";
        char c = ' ';
        int tam = 0;
        byte[] bayLei;

        RandomAccessFile aq;

        try {
            aq = new RandomAccessFile(aquivo, "rw");// "dbs/q3.db"

            if (ult == 0) {
                aq.writeInt(AC.ID_ac);
            }else{
                aq.writeInt(AC.ID_ac);
                aq.seek(ult);
            }

            ba = AC.toByteArray((int) 0);
            aux = AC.fromByteArray(ba);
            aq.writeChar('=');
            aq.writeInt(ba.length);
            aq.write(ba);

            ult = aq.getFilePointer();
            aq.writeChar('@');

            aq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ult;
    }

    public long gravX(Airplane_Crashes arrayAC[], long ult, String aquivo) { // OK
        Airplane_Crashes ac = new Airplane_Crashes();
        byte[] ba;
        String aux = "";
        char c = ' ';
        int tam = 0;
        byte[] bayLei;

        RandomAccessFile aq;

        try {
            aq = new RandomAccessFile(aquivo, "rw");//"dbs/q3.db"

            if (ult == 0) {
                aq.writeInt(1);
            }else{
                aq.seek(ult);
            }

            for (int i = 0; i < arrayAC.length && arrayAC[i] != null; i++) {
                ba = arrayAC[i].toByteArray((int) 0);
                aux = arrayAC[i].fromByteArray(ba);
                aq.writeChar('=');
                aq.writeInt(ba.length);
                aq.write(ba);
                ac = arrayAC[i];
            }
            ult = aq.getFilePointer();
            aq.writeChar('@');
            aq.seek(0);
            aq.writeInt(ac.ID_ac);

            aq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ult;
    }

}

class Airplane_Crashes {
    protected String Alltests = "";

    protected int ID_ac = 0;
    protected int Date = 0;
    protected int Time = 0;
    protected String Route = "";
    protected String Registration = "";
    protected int Aboard = 0;
    protected int Aboard_Pas = 0;
    protected int Aboard_Crew = 0;
    protected int Fatalities = 0;
    protected int Fatalities_Pas = 0;
    protected int Fatalities_Crew = 0;
    protected String L_O_A = "";
    //int Ground = 0;

    public Airplane_Crashes() {
        Alltests = "";

        ID_ac = 0;
        Date = 0;
        Time = 0;
        Route = "";
        Registration = "";
        Aboard = 0;
        Aboard_Pas = 0;
        Aboard_Crew = 0;
        Fatalities = 0;
        Fatalities_Pas = 0;
        Fatalities_Crew = 0;
        L_O_A = "";
        //Ground = 0;
    }

    public Airplane_Crashes clonagem() {
        Airplane_Crashes aclone = new Airplane_Crashes();
        aclone.Aboard = this.Aboard;
        aclone.Aboard_Crew = this.Aboard_Crew;
        aclone.Aboard_Pas = this.Aboard_Pas;
        aclone.Date = this.Date;
        aclone.Fatalities = this.Fatalities;
        aclone.Fatalities_Crew = this.Fatalities_Crew;
        aclone.Fatalities_Pas = this.Fatalities_Pas;
        aclone.ID_ac = this.ID_ac;
        aclone.L_O_A = this.L_O_A;
        aclone.Registration = this.Registration;
        aclone.Route = this.Route;
        aclone.Time = this.Time;
        return aclone;
    }

    public void escrevendoValores(){
        Scanner sc_esc = new Scanner(System.in);
        System.out.println("MesDiasAno");
        System.out.print("Date: ");
        Date = sc_esc.nextInt();
        sc_esc.nextLine(); // evita erros devido ao scanner de "int"

        System.out.println("\nHoraMinuto ");
        System.out.print("Time: ");
        Time = (int) sc_esc.nextInt();
        sc_esc.nextLine(); // evita erros devido ao scanner de "int"

        System.out.print("\nRoute: ");
        Route = sc_esc.nextLine();

        System.out.print("\nRegistration: ");
        Registration = sc_esc.nextLine();

        System.out.print("\nAboard: ");
        Aboard = (int) sc_esc.nextInt();
        sc_esc.nextLine(); // evita erros devido ao scanner de "int"

        System.out.print("\nAboard_Pas: ");
        Aboard_Pas = (int) sc_esc.nextInt();
        sc_esc.nextLine(); // evita erros devido ao scanner de "int"

        System.out.print("\nAboard_Crew: ");
        Aboard_Crew = (int) sc_esc.nextInt();
        sc_esc.nextLine(); // evita erros devido ao scanner de "int"

        System.out.print("\nFatalities: ");
        Fatalities = (int) sc_esc.nextInt();
        sc_esc.nextLine(); // evita erros devido ao scanner de "int"

        System.out.print("\nFatalities_Pas: ");
        Fatalities_Pas = (int) sc_esc.nextInt();
        sc_esc.nextLine(); // evita erros devido ao scanner de "int"

        System.out.print("\nFatalities_Crew: ");
        Fatalities_Crew = (int) sc_esc.nextInt();
        sc_esc.nextLine(); // evita erros devido ao scanner de "int"

        System.out.print("\nSeparado, por, virgula: ");
        System.out.print("\nL_O_A: ");
        L_O_A = sc_esc.nextLine();

        //System.out.print("\nGround: ");
        //Ground = (int) sc_esc.nextInt();
        //sc_esc.nextLine(); // evita erros devido ao scanner de "int"

        System.out.print("\n");
        //sc_esc.close(); // Se usado causa conflito no "main"
    }

    public byte[] toByteArray(int id) throws IOException{

        ByteArrayOutputStream baos_ac = new ByteArrayOutputStream();
        DataOutputStream dos_ac = new DataOutputStream(baos_ac);

        if (id != 0) {
            dos_ac.writeInt(id);
        }else{
            dos_ac.writeInt(ID_ac);
        }
        dos_ac.writeInt(Date);
        dos_ac.writeInt(Time);
        dos_ac.writeUTF(Route);
        dos_ac.writeUTF(Registration);
        dos_ac.writeInt(Aboard);
        dos_ac.writeInt(Aboard_Pas);
        dos_ac.writeInt(Aboard_Crew);
        dos_ac.writeInt(Fatalities);
        dos_ac.writeInt(Fatalities_Pas);
        dos_ac.writeInt(Fatalities_Crew);
        dos_ac.writeUTF(L_O_A);
        //dos_ac.writeInt(Ground);

        dos_ac.close();
        baos_ac.close();

        return baos_ac.toByteArray();
    }

    public String fromByteArray(byte ba_ac[]) throws IOException {
        String aux = "";
        ByteArrayInputStream bais_ac = new ByteArrayInputStream(ba_ac);
        DataInputStream dis_ac = new DataInputStream(bais_ac);

        ID_ac = dis_ac.readInt();
        Date = dis_ac.readInt();
        Time = dis_ac.readInt();
        Route = dis_ac.readUTF();
        Registration = dis_ac.readUTF();
        Aboard = dis_ac.readInt();
        Aboard_Pas = dis_ac.readInt();
        Aboard_Crew = dis_ac.readInt();
        Fatalities = dis_ac.readInt();
        Fatalities_Pas = dis_ac.readInt();
        Fatalities_Crew = dis_ac.readInt();
        L_O_A = dis_ac.readUTF();
        //Ground = dis_ac.readInt();
        // Tratamento de valores

        String ctpv = "" + Date;// 00/09/9999
        String ctpv_tmp = "";
        if (!ctpv.equals("") && !ctpv.equals("-1")) { // Tratamento de valores ante null
            for (int i = 1; i <= ctpv.length(); i++) {
                ctpv_tmp = ctpv.charAt(ctpv.length()-i) + ctpv_tmp;
                if (i == 4 || i == 6) {
                    ctpv_tmp = "/" + ctpv_tmp;
                }
            } // ano
            aux = " | " + ID_ac + " | ";
            int dtam = 8 - ctpv.length();
            for (int i = 1; i <= dtam; i++) {
                if (i == 3 || i == 5) {
                    aux += "/";
                }
                aux += "0"; // 00 09 9999
            }
            aux += ctpv_tmp + " ; ";
        }else{
            aux = " | " + ID_ac + " | "
                    + "null" + " ; ";
        }
        
        

        ctpv = "" + Time;// 12:23
        ctpv_tmp = "";
        if (!ctpv.equals("") && !ctpv.equals("-1")) { // Tratamento de valores ante null
            for (int i = 1; i <= ctpv.length(); i++) {
                ctpv_tmp = ctpv.charAt(ctpv.length()-i) + ctpv_tmp;
                if(i == 2){ctpv_tmp = ":" + ctpv_tmp;}
            } // hora
            if (ctpv.length() == 1) {
                aux += "00:0" + ctpv_tmp + " ; ";
            }else if (ctpv.length() == 2) {
                aux += "00" + ctpv_tmp + " ; ";
            }else if(ctpv.length() == 3){
                aux += "0" + ctpv_tmp + " ; ";
            }else{
                aux += ctpv_tmp + " ; ";
            }
        }else{
            aux += "null " + " ; ";
        }

        if (!Route.equals("")) {
            aux += Route + " ; ";
        }else{
            aux += "null" + " ; ";
        }

        if (!Registration.equals("")) {
            aux += Registration + " ; ";
        }else{
            aux += "null" + " ; ";
        }

        if (Aboard == -1) {
            aux += "null" + " ; ";
        }else{
            aux += Aboard + " ; ";
        }

        if (Aboard_Pas == -1) {
            aux += "null" + " ; ";
        }else{
            aux += Aboard_Pas + " ; ";
        }

        if (Aboard_Crew == -1) {
            aux += "null" + " ; ";
        }else{
            aux += Aboard_Crew + " ; ";
        }

        if (Fatalities == -1) {
            aux += "null" + " ; ";
        }else{
            aux += Fatalities + " ; ";
        }

        if (Fatalities_Pas == -1) {
            aux += "null" + " ; ";
        }else{
            aux += Fatalities_Pas + " ; ";
        }

        if (Fatalities_Crew == -1) {
            aux += "null" + " ; ";
        }else{
            aux += Fatalities_Crew + " ; ";
        }

        ctpv = "" + L_O_A;
        ctpv_tmp = "";
        if (!ctpv.equals("") && !ctpv.equals("-1")){
            aux += L_O_A + " ; ";
        }else{
            aux += "null" + " ; ";
        }
        
        // String com todos os valores
        /*aux = " | " + ID_ac + " | "
                + Date + " ; "
                + Time + " ; "
                + Route + " ; "
                + Registration + " ; "
                + Aboard + " ; "
                + Aboard_Pas + " ; "
                + Aboard_Crew + " ; "
                + Fatalities + " ; "
                + Fatalities_Pas + " ; "
                + Fatalities_Crew + " ; "
                + L_O_A + " ; "
                + Ground + " ; ";*/
        return aux;
    }

    public void SeparaValores(String s) {
        // Scanner sc = new Scanner(System.in);
        Alltests = "";
        int i = 0;
        while (i < s.length() && s.charAt(i) != ';') {
            if (s.charAt(i) != '/') {
                Alltests += s.charAt(i);
            }
            i++;
        }
        if (Alltests.equals("")) {
            Date = -1;
        } else {
            Date = Integer.parseInt(Alltests);
        }
        // System.out.println(Date);

        i++;
        Alltests = "";
        int data_aux = 1;
        while (i < s.length() && s.charAt(i) != ';') {
            if (data_aux <= 5 && s.charAt(i) != ':') {
                Alltests += s.charAt(i);
            }
            i++;
            data_aux++;
        }

        if (Alltests.equals("")) {
            Time = -1;
        } else {
            Time = (int) Integer.parseInt(Alltests);
        }

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        Route = Alltests;
        // System.out.println(Route);

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        Registration = Alltests;
        // System.out.println(Registration);

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        if (Alltests.equals("NULL")) {
            Aboard = -1;
        } else {
            Aboard = (int) Integer.parseInt(Alltests);
        }
        // System.out.println(Aboard);

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        // System.out.println("=" + Alltests);
        if (Alltests.equals("NULL")) {
            Aboard_Pas = -1;
        } else {
            Aboard_Pas = (int) Integer.parseInt(Alltests);
        }
        // System.out.println(Aboard_Pas);

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        if (Alltests.equals("NULL")) {
            Aboard_Crew = -1;
        } else {
            Aboard_Crew = (int) Integer.parseInt(Alltests);
        }
        // System.out.println(Aboard_Crew);

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        if (Alltests.equals("NULL")) {
            Fatalities = -1;
        } else {
            Fatalities = (int) Integer.parseInt(Alltests);
        }
        // System.out.println(Fatalities);

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        if (Alltests.equals("NULL")) {
            Fatalities_Pas = -1;
        } else {
            Fatalities_Pas = (int) Integer.parseInt(Alltests);
        }
        // System.out.println(Fatalities_Pas);

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        if (Alltests.equals("NULL")) {
            Fatalities_Crew = -1;
        } else {
            Fatalities_Crew = (int) Integer.parseInt(Alltests);
        }
        // System.out.println(Fatalities_Crew);

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        L_O_A = Alltests;
        // System.out.println(L_O_A);

        i++;
        Alltests = "";
        while (i < s.length() && s.charAt(i) != ';') {
            Alltests += s.charAt(i);
            i++;
        }
        if (Alltests.equals("NULL")) {
            //Ground = -1;
        } else {
            //Ground = (int) Integer.parseInt(Alltests);
        }
        // System.out.println(Ground);

        // System.out.println(s);
    }
}

class Cruda {
    public void atualizarRegistro(int id) {
        Airplane_Crashes aC = new Airplane_Crashes();
        hashira dasChamas = new hashira();
        RandomAccessFile arq;
        byte[] ba;
        byte[] ba_aux;
        long loc = encontrar(id);
        long loaux = 0;

        try {
            arq = new RandomAccessFile(tp1.md3, "rw");
            int ult = arq.readInt();
            arq.seek(loc);
            char c = arq.readChar();
            int test = 0;
            char c_test;
            int tam = arq.readInt();

            aC.escrevendoValores();
            ba = aC.toByteArray(id);

            arq.seek(loc);
            if (tam > ba.length) {
                c = arq.readChar();
                test = arq.readInt();
                arq.write(ba);
            }else{
                delet(id);
                
                /*
                 * int posi_id = arq.readInt();
                 * //posi++;
                 * long auxtest = ultimaPosi( posi_id);
                 * arq.seek(auxtest);
                 * c_test = arq.readChar();
                 * tam = arq.readInt();
                 * 
                 * arq.seek(auxtest);
                 * byte[] ba_aux = new byte[tam];
                 * c_test = arq.readChar();
                 * test = arq.readInt();
                 * arq.read(ba_aux);
                 * 
                 * arq.writeChar('=');
                 * arq.writeInt(ba.length); // Tamano do registro em bytes
                 * arq.write(ba);
                 * 
                 * arq.writeChar('@'); // fim do arquivo
                 * 
                 * arq.seek(0);
                 * arq.writeInt(id);
                 */

                arq.seek(ultimaPosi(ult));
                loaux = arq.getFilePointer();
                
                c_test = arq.readChar();
                test = arq.readInt();
                ba_aux = new byte[test];
                arq.read(ba_aux);

                loaux = arq.getFilePointer();
                dasChamas.inserir(id, loaux); // Vincula com Hash
                arq.writeChar('=');
                arq.writeInt(ba.length); // Tamano do registro em bytes
                arq.write(ba);

                loaux = arq.getFilePointer();
                arq.writeChar('@'); // fim do arquivo

                arq.seek(0);
                arq.writeInt(id);

                arq.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar - " + e.getMessage());
        }


    }

    public void delet(int id_del) {
        RandomAccessFile arqR2;
        hashira dasChHashira = new hashira();

        long ender_del = encontrar((int)id_del);
        try {
            if (ender_del != 0) {
                arqR2 = new RandomAccessFile(tp1.md3, "rw");
                arqR2.seek(ender_del);
                arqR2.writeChar('*');
                dasChHashira.deletar(id_del); // deleta vinculo com Hash
                System.out.println("Deletado");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void printaSelecao(long ender) {
        RandomAccessFile arqR2;
        Airplane_Crashes ac = new Airplane_Crashes();

        //limpar();

        String aux = "";
        byte[] ba;
        int len;
        char R_I_P = '0';

        try {
            arqR2 = new RandomAccessFile(tp1.md3, "rw");
            arqR2.seek(ender);

            R_I_P = arqR2.readChar();
            if (R_I_P == '=') {
                len = arqR2.readInt();
                ba = new byte[len];
                arqR2.read(ba);
                aux = ac.fromByteArray(ba);
                System.out.println(aux);

            } else if (R_I_P == '*') {
                len = arqR2.readInt();
                ba = new byte[len];
                arqR2.read(ba);
                System.out.println(" Nao Encontrado");
            }

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage() + " = Nao Encontrado");
        }
    }

    public long encontrar(int id_temp) {
        RandomAccessFile arqR2;
        Airplane_Crashes ac = new Airplane_Crashes();
        Airplane_Crashes ac_tmp = new Airplane_Crashes();

        //limpar();

        String aux = "";
        byte[] ba;
        int len;
        char R_I_P = '0';
        long endereco_temp = 0;
        long endereco = 0;

        try {
            arqR2 = new RandomAccessFile(tp1.md3, "rw");
            int ult = arqR2.readInt();

            while (R_I_P != '@') { // mostra todos os arquivos
                endereco_temp = arqR2.getFilePointer();
                R_I_P = arqR2.readChar();
                if (R_I_P == '=') {
                    endereco = endereco_temp;
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                    aux = ac.fromByteArray(ba);
                    if (ac.ID_ac == id_temp) {
                        //System.out.println("\n modulo: " + aux);
                        break;
                    }
                } else if (R_I_P == '*') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                    aux = ac_tmp.fromByteArray(ba);
                    if (ac_tmp.ID_ac == id_temp) {
                        System.out.println(" = Nao Encontrado");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage() + " = Nao Encontrado");
            endereco = 0;
        }
        return endereco;
    }

    public long ultimaPosi(int id_temp) {
        RandomAccessFile arqR2;
        Airplane_Crashes ac = new Airplane_Crashes();

        //limpar();

        String aux = "";
        byte[] ba;
        int len;
        char R_I_P = '0';
        long endereco_temp = 0;
        long endereco = 0;

        try {
            arqR2 = new RandomAccessFile(tp1.md3, "rw");
            int ult = arqR2.readInt();

            while (R_I_P != '@') { // mostra todos os arquivos
                endereco_temp = arqR2.getFilePointer();
                R_I_P = arqR2.readChar();

                endereco = endereco_temp;
                len = arqR2.readInt();
                ba = new byte[len];
                arqR2.read(ba);
                aux = ac.fromByteArray(ba);
                if (ac.ID_ac == id_temp) {
                    System.out.println("\n modulo: " + aux);
                    break;
                }
            }
            arqR2.close();
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage() + " = Nao Encontrado");
            endereco = 0;
        }
        return endereco;
    }

    public void novaLinha(int ID_prox){
        Airplane_Crashes AC = new Airplane_Crashes();
        hashira dasChamas = new hashira();

        RandomAccessFile arq;
        byte[] ba_cria;
        byte[] ba_aux;
        int posi_id;

        try {
            arq = new RandomAccessFile(tp1.md3, "rw");
            posi_id = arq.readInt();
            ID_prox = posi_id;
            ID_prox++;
             
            
            //posi++;
            arq.seek(ultimaPosi(posi_id));
            
            char c = arq.readChar();
            int tam = arq.readInt();
            //ID_prox = arq.readInt();

            AC.escrevendoValores(); // Pega a nova linha de valores com o usuario
            //limpar();
            ba_cria = AC.toByteArray(ID_prox); // Junta os valores em um array de bytes

            arq.seek(ultimaPosi(posi_id));
            ba_aux = new byte[tam];
            arq.readChar();
            arq.readInt();
            arq.read(ba_aux);

            dasChamas.inserir(ID_prox, arq.getFilePointer()); // Vincula com Hash
            arq.writeChar('=');
            arq.writeInt(ba_cria.length); // Tamano do registro em bytes
            arq.write(ba_cria);
            
            arq.writeChar('@'); // fim do arquivo

            arq.seek(0);
            arq.writeInt(ID_prox);

            arq.close();
            tp1.info = "Nova linha atribuida         |";
        } catch (Exception e) {
            // Todo: handle exception
        }
    }
}

class sortuda {
    sortuda esq;
    sortuda dir;
    Airplane_Crashes elemento;

    public sortuda(){
        esq = null;
        dir = null;
        elemento = null;
    }

    public sortuda(Airplane_Crashes ac_f){
        esq = null;
        dir = null;
        elemento = ac_f;
    }

    public sortuda inserir(Airplane_Crashes x, sortuda i) throws Exception {
        if (i == null || i.elemento == null) {
            i = new sortuda(x);
        } else if (x.ID_ac < i.elemento.ID_ac) {
            i.esq = inserir(x, i.esq);
        } else if (x.ID_ac > i.elemento.ID_ac) {
            i.dir = inserir(x, i.dir);
        } else {
            throw new Exception("Erro!");
        }
        return i;
    }

    public Airplane_Crashes[] caminharCentral(sortuda i, Airplane_Crashes ac[]) {
        if (i != null) {
            ac = caminharCentral(i.esq, ac);
            int ip = 0;
            while (ac[ip] != null) {ip++;}
            ac[ip] = i.elemento;
            //System.out.print(i.elemento.ID_ac + " == " + ac[ip].ID_ac);
            ac = caminharCentral(i.dir, ac);
        }
        return ac;
    }

}

class listaInvertida{
    public void encontroInvertido() {
        //Location,Operator,AC Type
        String location = "";
        String operator = "";
        String ac_type = "";

        Scanner sc = new Scanner(System.in);
        System.out.println("Psquisa de id's pela L_O_A");
        System.out.print("Insira o Location: ");
        location = sc.nextLine();
        System.out.print("Insira o Operator: ");
        operator = sc.nextLine();
        System.out.print("Insira o ac_type: ");
        ac_type = sc.nextLine();
        //sc.close();
        RandomAccessFile arqR2;
        Airplane_Crashes ac = new Airplane_Crashes();

        int ult_posi = 0;
        String aux = "";
        byte[] ba;
        int len;
        char R_I_P = '0';

        try {
            arqR2 = new RandomAccessFile(tp1.md3, "rw");
            ult_posi = arqR2.readInt();

            while (R_I_P != '@') { // mostra todos os arquivos
                R_I_P = arqR2.readChar();
                if (R_I_P == '=') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                    aux = ac.fromByteArray(ba);
                    if (ac.L_O_A.contains(ac_type)) {
                        System.out.println(aux);
                    }else if (ac.L_O_A.contains(operator)) {
                        System.out.println(aux);
                    }else if (ac.L_O_A.contains(location)) {
                        System.out.println(aux);
                    }
                    
                } else if (R_I_P == '*') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                } else if(R_I_P == '@'){}
            }
            arqR2.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " = Fim " + ult_posi);
            System.out.println(" encontroInvertido <-- ");
        }
    }
}

class hashira{
    int p = 2;
    int buck_tam = 4;

    public long localizar(int id) {
        RandomAccessFile bucket;
        RandomAccessFile index;
        long myloc = 0;
        int mod = 0;

        long locarq = 0;

        int idatual = 0;
        long locatual = 0;

        try {
            bucket = new RandomAccessFile("./dbs/hash/bucket.db", "rw");
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");
            p = index.readInt();

            mod = id % elevada(2, p);
            myloc = searcheando(mod);

            bucket.seek(myloc);
            for (int i = 0; i < buck_tam; i++) {
                idatual = bucket.readInt();
                System.out.print(idatual);
                System.out.print(", ");
                locatual = bucket.readLong();
                System.out.print(locatual);
                System.out.print(" | ");
                if (id == idatual) {
                    locarq = locatual;
                }
            }
            System.out.println();
            index.close();
            bucket.close();

            

            //printandoBuck();
            //System.out.println();

        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("localizar <--");
        }
        return locarq;
    }

    public void deletar(int idArq) {
        RandomAccessFile bucket;
        RandomAccessFile index;

        long myloc = 0;
        int id = 0;
        try {
            bucket = new RandomAccessFile("./dbs/hash/bucket.db", "rw");
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");
            p = index.readInt();

            bucket.seek(searcheando(idArq % elevada(2, p)));
            index.close();
            
            for (int i = 0; i < buck_tam; i++) {
                myloc = bucket.getFilePointer();
                id = bucket.readInt();
                bucket.readLong();
                if (id == idArq) {
                    bucket.seek(myloc);
                    bucket.writeInt(-1);
                    bucket.writeLong(0);
                }
            }
            bucket.close();


        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("deletar <--");
        }
    }

    public void inserir(int arqId, long arqLoc) {
        RandomAccessFile bucket;
        RandomAccessFile index;
        long locBuckt = 0;
        int mod = 0;

        try {
            bucket = new RandomAccessFile("./dbs/hash/bucket.db", "rw");
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");
            p = index.readInt();
            index.close();
            bucket.close();

            mod = arqId % elevada(2,p);
            locBuckt = searcheando(mod);
            incrementoBuckt(locBuckt, arqId, arqLoc, mod);
            //printandoBuck();
            //System.out.println();

        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("inserir <--");
        }
    }

    public void atualizarPosi() { // atualiza a localizacao de todos os Id's
        RandomAccessFile arqR2;
        Airplane_Crashes ac = new Airplane_Crashes();
        hashira dasChHashira = new hashira();
        RandomAccessFile index;
        long myloc = 0;

        int ult_posi = 0;
        String aux = "";
        byte[] ba;
        int len;
        char R_I_P = '0';

        try {
            arqR2 = new RandomAccessFile(tp1.md3, "rw");
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");
            p = index.readInt();
            index.close();
            ult_posi = arqR2.readInt();

            while (R_I_P != '@') { // mostra todos os arquivos
                myloc = arqR2.getFilePointer();
                R_I_P = arqR2.readChar();
                if (R_I_P == '=') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                    aux = ac.fromByteArray(ba);
                    dasChHashira.alteraPosi(ac.ID_ac % elevada(2, p), myloc, ac.ID_ac);
                    //System.out.println(aux);
                } else if (R_I_P == '*') {
                    len = arqR2.readInt();
                    ba = new byte[len];
                    arqR2.read(ba);
                } else if(R_I_P == '@'){}
            }
            arqR2.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "atualizarPosi  " + ult_posi);
        }
    }

    public void alteraPosi(int mod, long noloc, int idArq) {
        // pelo mod encontra a posicao do idArq e grava a nova localizacao do arquivo
        RandomAccessFile index;
        try {
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");
            p = index.readInt();
            index.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("printandoBuck <--");
        }

        RandomAccessFile bucket;
        int idLocal = 0;
        long myloc = 0;
        try {
            bucket = new RandomAccessFile("./dbs/hash/bucket.db", "rw");
            bucket.readLong();
            bucket.seek(searcheando(mod));
            for (int i = 0; i < buck_tam; i++) {
                myloc = bucket.getFilePointer();
                idLocal = bucket.readInt();
                bucket.readLong();
                if (idLocal == idArq) {
                    bucket.seek(myloc);
                    bucket.readInt();
                    bucket.writeLong(noloc);
                }
            }
            bucket.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("alteraPosi <--");
        }
    }

    public long searcheando(int mod) {
        RandomAccessFile index;
        long loc =  0;

        try {
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");

            index.readInt();
            index.skipBytes(12*mod);
            index.readInt();
            loc = index.readLong();
            
            index.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("searcheando <--");
        }
        return loc;
    }

    public void incrementoBuckt(long lok, int arqId, long arqLoc, int mod) {
        RandomAccessFile bucket;
        int id = 0;
        long myloc = 0;

        int idesvio = 0;
        try {
            bucket = new RandomAccessFile("./dbs/hash/bucket.db", "rw");
            bucket.seek(lok);
            for (int i = 0; i < buck_tam; i++) {
                myloc = bucket.getFilePointer();
                id = bucket.readInt();
                bucket.readLong();
                if (id == -1) {
                    bucket.seek(myloc);
                    bucket.writeInt(arqId);
                    bucket.writeLong(arqLoc);
                    break;
                }else if(i == 3){
                    if (validacao(lok)) {
                        idesvio = desvio(arqId % elevada(2,p));
                        verificador(lok, idesvio);
                        inserir(arqId, arqLoc);
                    }else{
                        criaIndex();
                        idesvio = desvio(arqId % elevada(2,p));
                        verificador(lok, idesvio);
                        inserir(arqId, arqLoc);
                    }
                    
                    
                    // // criando desnecessario
                    //verificador(lok, mod);
                }
            }

            bucket.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("incrementoBuckt <--");
        }
    }

    public void verificador(long lok, int idesvio) {// ver quais tera de ser trocados
        RandomAccessFile bucket;
        int id = 0;
        long aloc = 0;
        long myloc = 0;

        int mudo;
        //int mud;
        try {
            bucket = new RandomAccessFile("./dbs/hash/bucket.db", "rw");
            bucket.seek(lok);
            for (int i = 0; i < buck_tam; i++) {
                myloc = bucket.getFilePointer();
                id = bucket.readInt();
                aloc = bucket.readLong();
                //mud = segundo(lok);
                mudo = id % elevada(2,p);
                if ( id != -1 && idesvio == mudo) {// acessando errado
                    bucket.seek(myloc);
                    bucket.writeInt(-1);
                    bucket.writeLong(0);
                    inserir(id, aloc);
                }
            }

            bucket.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("verificador <--");
        }
    }

    public boolean validacao(long arqLoc) { // olha se eh preciso de um novo bucket ou aumentar o index
        RandomAccessFile index;

        long loc = 0;
        int cont = 0;

        try {
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");

            index.readInt();
            for (int i = 0; i < elevada(2, p); i++) {
                index.getFilePointer();
                index.readInt(); // id
                loc = index.readLong(); // loc
                if (arqLoc == loc) {
                    cont++;
                }
            }

            index.close();
            if (cont == 2) {
                return true;
                //desvio(mood);
            }else{
                return false;
                //criaIndex();
            }

        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("validacao <--");
        }
        return false;
    }

    public int desvio(int mood) { // direciona um novo bucket
        RandomAccessFile index;
        long myloc = 0;
        int id = 0;
        int idesvio = 0;
        mood = segundo(searcheando(mood));

        try {
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");
            
            index.readInt();
            for (int i = 0; i < elevada(2, p); i++) {
                myloc = index.getFilePointer();
                id = index.readInt(); // id
                index.readLong(); // loc
                if (id == mood) {
                    index.seek(myloc);
                    idesvio = index.readInt(); // id
                    index.writeLong(criaBuckts()); // loc
                    
                }
            }
            
            index.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("desvio <--");
        }
        return idesvio;
    }

    public int segundo(long arqLoc) {
        RandomAccessFile index;
        long loc = 0;
        int cont = 0;
        long myloc = 0;
        int id = 0;

        try {
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");
            index.readInt();
            for (int i = 0; i < elevada(2, p); i++) {
                myloc = index.getFilePointer();
                index.readInt(); // id
                loc = index.readLong(); // loc
                if (arqLoc == loc) {
                    cont++;
                    if (cont == 2) {
                        index.seek(myloc);
                        id = index.readInt();
                        index.close();
                        return id;
                    }
                }
            }

        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("validacao <--");
        }
        return -1;
    }

    public void criaIndex() {
        RandomAccessFile index;


        try {
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");
            
            index.readInt();
            for (int i = 0; i < elevada(2, p); i++) {
                index.readInt(); // id
                index.readLong(); // loc
            }
            int ptemp = elevada(2, p);
            p = p+1;
           
            for (int i = ptemp; i < elevada(2, p); i++) {
                index.writeInt(i); // id
                index.writeLong(searcheando(i - ptemp)); // loc
            }
            index.seek(0);
            index.writeInt(p); // mod
            
            index.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("criaIndex <--");
        }
    }

    public long criaBuckts() { // R
        RandomAccessFile bucket;
        long finaly;
        long myLoc = 0;

        try {
            bucket = new RandomAccessFile("./dbs/hash/bucket.db", "rw");

            finaly = bucket.readLong();
            bucket.seek(finaly);
            myLoc = bucket.getFilePointer();

            for (int j = 0; j < buck_tam; j++) {
                bucket.writeInt(-1); // chave
                bucket.writeLong(0); // ender
            }
            finaly = bucket.getFilePointer();
            bucket.seek(0);
            bucket.writeLong(finaly);
            bucket.close();

        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("criaBuckt <--");
        }
        return myLoc;
    }

    public void iniciarIndex() {
        RandomAccessFile index;

        try {
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");

            index.writeInt(p); // mod
            for (int i = 0; i < elevada(2, p); i++) {
                index.writeInt(i); // id
                index.writeLong(criaBuckts()); // loc
            }
            
            index.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("iniciarIndex <--");
        }
    }

    public void incialBuckt() {
        RandomAccessFile bucket;
        long myLoc = 0;

        try {
            File file = new File("./dbs/hash/bucket.db");
            File file2 = new File("./dbs/hash/bucket.db");
            file.delete();
            file2.delete();
            
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("criaBuckt <--0");
        }

        try {
            bucket = new RandomAccessFile("./dbs/hash/bucket.db", "rw");

            bucket.writeLong(0);
            myLoc = bucket.getFilePointer();
            bucket.seek(0);
            bucket.writeLong(myLoc);

            bucket.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("criaBuckt <--");
        }
    }

    public void printandoBuck() {
        RandomAccessFile index;
        try {
            index = new RandomAccessFile("./dbs/hash/index.db", "rw");
            p = index.readInt();
            index.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("printandoBuck <--");
        }

        RandomAccessFile bucket;
        try {
            bucket = new RandomAccessFile("./dbs/hash/bucket.db", "rw");
            bucket.readLong();
            for (int j = 0; j < elevada(2, p); j++) {
                bucket.seek(searcheando(j));
                
                System.out.print("[" + j + "]-> ");
                for (int i = 0; i < buck_tam; i++) {
                    System.out.print(bucket.readInt());
                    System.out.print(", ");
                    System.out.print(bucket.readLong());
                    System.out.print(" | ");
                    
                }
                System.out.println("- " + searcheando(j));
            }

            bucket.close();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("printandoBuck <--");
        }
    }

    public int elevada(int ba, int ele) {
        int r = 1;
        for (int i = 0; i < ele; i++) {
            r = ba * r;
        }
        return r;
    }
}
