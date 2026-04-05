import java.util.HashMap;

public class task5 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(0, "Bugs");
        hashMap.put(1, "Donald");
        hashMap.put(2, "Daisy");
        hashMap.put(3, "Mickey");
        hashMap.put(4, "Jonny");
        hashMap.put(5, "Goofy");
        hashMap.put(6, "Pluto");
        hashMap.put(7, "Minnie");
        hashMap.put(8, "Daffy");
        hashMap.put(9, "Porky");
        

        System.out.println("Ключи больше 5: ");
        for (Integer key : hashMap.keySet()) {
            if (key > 5) {
                System.out.println(key);
            }
        }

        if (hashMap.containsKey(0)) {
            System.out.println("Значение по ключу 0: " + hashMap.get(0));
        }

        int result = 1;
        
        for (Integer key: hashMap.keySet()) {
            if (hashMap.get(key).length() > 5) {
                result = result * key;
            }
        }

        System.out.println("Результат умножения ключей, у которых длина строки больше 5: " + result);

    }
}
