package Pre;

interface I {
    void m();
}

class A implements I {
    public void m() {
        System.out.println("Método implementado desde A");
    }
}

public class Anonimas01 {
    public static void main(String[] args) {
       // I i = new A();
       // i.m();

       I i = new I(){
        public void m(){
            System.out.println("Método implementado desde clase anonima");
        }
       };
       i.m();
    }

}
