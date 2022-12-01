import java.util.*;

public class StudyCase {
    static int flag;
    static String userName;
    static String userPass;
    static Scanner input = new Scanner(System.in);
    static boolean Awal;
    static boolean kedua;

    class admin{
        /* saya menggunakan static disetiap Arraylistnya agar mudah diakses di Class lain */
        static ArrayList<String> usernameAdmin = new ArrayList<String>();
        static ArrayList<String> passAdmin = new ArrayList<String>();
        admin(String nama, String pass){
            usernameAdmin.add(nama);
            passAdmin.add(pass);
        }
    }
    class client{
      /* class client ini dibuat untuk menyimpan data dari para client seperti, Username, password, deskripsi
     * Project, batas waktu project, metode pembayaran, dan tawaran harga untuk para freelancer
     */
        static ArrayList<String> usernameClient = new ArrayList<String>();
        static ArrayList<String> passClient = new ArrayList<String>();
        static ArrayList<String> deskProject = new ArrayList<String>();
        static ArrayList<String> deadline = new ArrayList<String>();
        static ArrayList<String> payMethod = new ArrayList<String>();
        static ArrayList<String> fee = new ArrayList<String>();
        client(String nama, String pass, String deskProjectinput, String deadlineinput, String payMethodinput, String feeinput){
            usernameClient.add(nama);
            passClient.add(pass);
            deskProject.add(deskProjectinput);
            deadline.add(deadlineinput);
            payMethod.add(payMethodinput);
            fee.add(feeinput);
        }
    }

    /* class freelance ini dibuat untuk menyimpan data dari para freelancer seperti, Username, password, nama client yang diambil
     * deskripsi Project, batas waktu project, metode pembayaran, dan tawaran harga yang dibayarkan ke freelancer
     */
    class freelances{
        static ArrayList<String> namafreelances = new ArrayList<String>();
        static ArrayList<String> passfreelances = new ArrayList<String>();
        static ArrayList<String> usernameClient = new ArrayList<String>();
        static ArrayList<String> deskProject = new ArrayList<String>();
        static ArrayList<String> deadline = new ArrayList<String>();
        static ArrayList<String> payMethod = new ArrayList<String>();
        static ArrayList<String> fee = new ArrayList<String>();
        freelances(String nama, String pass, String usernameClientinput, String deskProjectinput, String deadlineinput, String payMethodinput, String feeinput){
            namafreelances.add(nama);
            passfreelances.add(pass);
            usernameClient.add(usernameClientinput);
            deskProject.add(deskProjectinput);
            deadline.add(deadlineinput);
            payMethod.add(payMethodinput);
            fee.add(feeinput);
        }
    }

    /* saya membuat method untukcls agar terlihat lebih rapih */
    public static void cls() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /* saya juga membuat meethod untuk menerima inputan dari keyboard sebelum isi layar dihapus dengan cls() */
    public static void getch(){
        System.out.println("Tekan enter untuk melanjutkan");
        input.nextLine();
        input.nextLine();
    }

    /* Meethod ini saya gunakan untuk autentikasi akun yang login kedalam sistem */
    public static int cekrole(String userName, String userPass){
        if(admin.usernameAdmin.contains(userName)&&admin.passAdmin.contains(userPass)){
            return 1;
        }
        else if(client.usernameClient.contains(userName)&&client.passClient.contains(userPass)){
            return 2;
        }
        else if(freelances.namafreelances.contains(userName)&&freelances.passfreelances.contains(userPass)){
            return 3;
        }
        else{
            return -1;
        }
    }
    
    /* Method ini saya gunakan untuk membuat interface dari sisi Admin */
    public static void menuadmin(){
        int n;
        cls();
        System.out.println("-------------- ADMIN ---------------");
        System.out.println("Selamat datang admin");
        System.out.println("1. Lihat data");
        System.out.println("2. Hapus data");
        System.out.println("3. exit");
        n = input.nextInt();

        switch(n){
            case 1:
                System.out.println("lihat data");
                System.out.println("--------------- ADMIN --------------");
                System.out.println("data admin :");
                System.out.println("nama admin : "+admin.usernameAdmin);
                System.out.println("pass admin : "+admin.passAdmin);
                System.out.println("-----------------------------");
                System.out.println("data client :");
                System.out.println("nama client\t: "+client.usernameClient);
                System.out.println("pass client\t: "+client.passClient);
                System.out.println("deskProject client : "+client.deskProject);
                System.out.println("tenggat waktu client : "+client.deadline);
                System.out.println("payment method client : "+client.payMethod);
                System.out.println("fee client\t: "+client.fee);
                System.out.println("-----------------------------");
                System.out.println("data freelances :");
                System.out.println("nama freelances\t: "+freelances.namafreelances);
                System.out.println("pass freelances\t: "+freelances.passfreelances);
                System.out.println("nama client freelances : "+freelances.usernameClient);
                System.out.println("deskProject freelances : "+freelances.deskProject);
                System.out.println("tenggat waktu freelances : "+freelances.deadline);
                System.out.println("payment method freelances : "+freelances.payMethod);
                System.out.println("fee freelances\t: "+freelances.fee);
                System.out.println("-----------------------------");
                getch();
                break;
                
            case 2:
                cls();
                System.out.println("------------- ADMIN ----------------");
                System.out.println("1. Hapus data client");
                System.out.println("2. Hapus data freelances");
                System.out.println("3. exit");
                n = input.nextInt();

                switch(n){
                    case 1:
                        System.out.println("-----------------------------");
                        System.out.println("\t\tData client");
                        for(int i=0;i<client.usernameClient.size();i++){
                            System.out.println("Nama client\t: "+client.usernameClient.get(i));
                            System.out.println("Password client\t: "+client.passClient.get(i));
                            System.out.println("deskProject\t: "+client.deskProject.get(i));
                            System.out.println("Tenggat waktu\t: "+client.deadline.get(i));
                            System.out.println("Payment method\t: "+client.payMethod.get(i));
                            System.out.println("fee\t: "+client.fee.get(i));
                            System.out.println("-----------------------------");
                        }
                        System.out.println("Masukkan nama client yang ingin dihapus");
                        String namahapus = input.next();
                        if(client.usernameClient.contains(namahapus)){
                            int index = client.usernameClient.indexOf(namahapus);
                            client.usernameClient.remove(index);
                            client.passClient.remove(index);
                            client.deskProject.remove(index);
                            client.deadline.remove(index);
                            client.payMethod.remove(index);
                            client.fee.remove(index);
                            System.out.println("-----------------------------");
                            System.out.println("Data client berhasil dihapus");
                        }
                        else{
                            System.out.println("-----------------------------");
                            System.out.println("Data client tidak ditemukan");
                        }
                        break;
                    case 2:
                        System.out.println("-----------------------------");
                        System.out.println("\t\tData freelances");
                        for(int i=0;i<freelances.namafreelances.size();i++){
                            System.out.println("Nama freelances\t: "+freelances.namafreelances.get(i));
                            System.out.println("Password freelances\t: "+freelances.passfreelances.get(i));
                            System.out.println("Nama client\t: "+freelances.usernameClient.get(i));
                            System.out.println("deskProject\t: "+freelances.deskProject.get(i));
                            System.out.println("Tenggat waktu\t: "+freelances.deadline.get(i));
                            System.out.println("Payment method\t: "+freelances.payMethod.get(i));
                            System.out.println("fee\t: "+freelances.fee.get(i));
                            System.out.println("-----------------------------");
                        }
                        System.out.println("Masukkan nama freelances yang ingin dihapus");
                        String namahapus2 = input.next();
                        if(freelances.namafreelances.contains(namahapus2)){
                            int index = freelances.namafreelances.indexOf(namahapus2);
                            freelances.namafreelances.remove(index);
                            freelances.passfreelances.remove(index);
                            freelances.usernameClient.remove(index);
                            freelances.deskProject.remove(index);
                            freelances.deadline.remove(index);
                            freelances.payMethod.remove(index);
                            freelances.fee.remove(index);
                            System.out.println("-----------------------------");
                            System.out.println("Data freelances berhasil dihapus");
                        }
                        else{
                            System.out.println("-----------------------------");
                            System.out.println("Data freelances tidak ditemukan");
                        }
                        break;
                        case 3:
                            kedua = false;
                            break;
                    }
                break;
            case 3:
            kedua = false;
            break;
            }
        }
        
    /* Method ini saya gunakan untuk interface dari sisi Client */
    public static void menuclient(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("-------------- CLIENT ---------------");
        System.out.println("\t\tUpload project");
        System.out.print("deskProject : ");
        String deskProject = input.next();
        client.deskProject.add(deskProject);
        System.out.print("Tenggat waktu : ");
        String deadline = input.next();
        deadline = input.next();
        client.deadline.add(deadline);
        System.out.print("Payment method : ");
        String payMethod = input.next();
        client.payMethod.add(payMethod);
        System.out.print("fee\t: ");
        String fee = input.next();
        client.fee.add(fee);
        System.out.println("-----------------------------");
        System.out.println("Project berhasil diupload");
        kedua = false;
    }

    /* Method ini merupakan interface dari sisi Freelancer */
    public static void menufreelances(){
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("-------------- Freelancer ---------------");
        System.out.println("1. Lihat project");
        System.out.println("2. Ambil project");
        System.out.println("3. lihat project yang diambil");
        System.out.println("4. exit");
        n = input.nextInt();
        
        switch(n){
            case 1:
                System.out.println("-------------- Freelancer ---------------");
                System.out.println("\t\tData project");
                if(client.usernameClient.isEmpty()){
                    System.out.println("-----------------------------");
                    System.out.println("Tidak ada project");
                    getch();
                }
                else{
                    for(int i=0;i<client.usernameClient.size();i++){
                        System.out.println("Nama client\t: "+client.usernameClient.get(i));
                        System.out.println("deskProject\t: "+client.deskProject.get(i));
                        System.out.println("Tenggat waktu\t: "+client.deadline.get(i));
                        System.out.println("Payment method\t: "+client.payMethod.get(i));
                        System.out.println("fee: "+client.fee.get(i));
                        System.out.println("-----------------------------");
                    }
                    getch();
                }
                break;
            case 2:
                System.out.println("-------------- Freelancer ---------------");
                System.out.println("\t\tData project");
                for(int i=0;i<client.usernameClient.size();i++){
                    System.out.println("Nama client\t: "+client.usernameClient.get(i));
                    System.out.println("deskProject\t: "+client.deskProject.get(i));
                    System.out.println("Tenggat waktu\t: "+client.deadline.get(i));
                    System.out.println("Payment method\t: "+client.payMethod.get(i));
                    System.out.println("fee\t: "+client.fee.get(i));
                    System.out.println("-----------------------------");
                }
                System.out.println("Masukkan nama client yang ingin diambil");
                /* Cek kondisi ketika data freelancer isEmpty() */
                if(client.usernameClient.isEmpty()){
                    System.out.println("--------------- Freelancer --------------");
                    System.out.println("Tidak ada project");
                }else{
                    String usernameClient = input.next();
                    if(client.usernameClient.contains(usernameClient)){
                        int index = client.usernameClient.indexOf(usernameClient);
                        freelances.usernameClient.add(client.usernameClient.get(index));
                        freelances.deskProject.add(client.deskProject.get(index));
                        freelances.deadline.add(client.deadline.get(index));
                        freelances.payMethod.add(client.payMethod.get(index));
                        freelances.fee.add(client.fee.get(index));
                        cls();
                        System.out.println("-----------------------------");
                        System.out.println("Project berhasil diambil:");
                        for(int i=0;i<freelances.usernameClient.size();i++){
                            System.out.println("Nama client\t: "+freelances.usernameClient.get(i));
                            System.out.println("deskProject\t: "+freelances.deskProject.get(i));
                            System.out.println("Tenggat waktu\t: "+freelances.deadline.get(i));
                            System.out.println("Payment method\t: "+freelances.payMethod.get(i));
                            System.out.println("fee\t: "+freelances.fee.get(i));
                            System.out.println("-------------------------------");
                        }
                        /* karna saya menggunakan Arraylist jadi saya tinggal memanggil method remove */
                        client.usernameClient.remove(index);
                        client.passClient.remove(index);
                        client.deskProject.remove(index);
                        client.deadline.remove(index);
                        client.payMethod.remove(index);
                        client.fee.remove(index);
                    }
                    else{
                        System.out.println("-----------------------------");
                        System.out.println("Project tidak ditemukan");
                    }
                }
                break;
            case 3:
                System.out.println("-----------------------------");
                System.out.println("Data project yang diambil");
                if(freelances.usernameClient.isEmpty()){
                    System.out.println("-----------------------------");
                    System.out.println("Tidak ada project yang diambil");
                }
                else{
                    for(int i=0;i<freelances.usernameClient.size();i++){
                        System.out.println("Nama client\t: "+freelances.usernameClient.get(i));
                        System.out.println("deskProject\t: "+freelances.deskProject.get(i));
                        System.out.println("Tenggat waktu\t: "+freelances.deadline.get(i));
                        System.out.println("Payment method\t: "+freelances.payMethod.get(i));
                        System.out.println("fee\t: "+freelances.fee.get(i));
                        System.out.println("-----------------------------");
                    }
                }
                getch();
                break;
            case 4:
                kedua = false;
                break;
            }
            
        }
    
    public static void main(String[] args) {
        /* dibawah ini saya memasukkan beberapa data agar data sudah ada didalam database dan akun yang sudah terdaftar */
        admin.usernameAdmin.add("Irham");
        admin.passAdmin.add("1001");
        client.usernameClient.add("Racid");
        client.passClient.add("2002");
        client.deskProject.add("membuat database toko laptop");
        client.deadline.add("15-02-2021");
        client.payMethod.add("Transfer Bank");
        client.fee.add("1000000");
        freelances.namafreelances.add("Okin");
        freelances.passfreelances.add("3001");
        freelances.usernameClient.add("Racid");
        freelances.deskProject.add("membuat database toko laptop");
        freelances.deadline.add("15-02-2021");
        freelances.payMethod.add("Transfer Bank");
        freelances.fee.add("1000000");
        
        
        cls();
        System.out.println("--------------------------------");
        System.out.println("Selamat Datang di Program pencari bakat");
        System.out.println("--------------------------------");
        Awal = true; // kondisi
        kedua = true;
        while(Awal){
            cls();
            flag = 0;
            System.out.print("Masukan username: ");
            String namalogin = input.next();
            userName = namalogin;
            System.out.print("Masukan password: ");
            String passlogin = input.next();
            userPass = passlogin; 
            kedua = true; // Disini saya rubah lagi menjadi true agar tidak terjadi infinite loop dan dapat lanjut ke while selanjutnya
            while(kedua){
                flag = cekrole(userName, userPass);
                switch(flag){
                    case 1:
                        menuadmin();
                        cls();
                        break;
                    case 2:
                        menuclient();
                        cls();
                        break;
                    case 3:
                        menufreelances();
                        cls();
                        break;
                    default:
                        System.out.println("Username atau password salah");
                        kedua = false;
                        break;
                }
            }
        }
    }
}
