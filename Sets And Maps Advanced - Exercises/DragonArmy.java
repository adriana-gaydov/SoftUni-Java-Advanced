import java.util.*;

class Stats {
    private int damage, health, armor;

    public Stats(int damage, int health, int armor) {
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public String toString() {
        return String.format("damage: %d, health: %d, armor: %d", damage, health, armor);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Stats>> map = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String type = inputArgs[0];
            String name = inputArgs[1];
            String damageS = inputArgs[2];
            String healthS = inputArgs[3];
            String armorS = inputArgs[4];
            int damage, health, armor;

            if (damageS.equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(damageS);
            }

            if (healthS.equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(healthS);
            }

            if (armorS.equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(armorS);
            }
            map.putIfAbsent(type, new TreeMap<>());
            map.get(type).put(name, new Stats(damage, health, armor));
        }
        map.entrySet().forEach(e -> {
            System.out.printf("%s::%s%n",e.getKey(), getAverageStats(e.getValue()));
            e.getValue().entrySet().forEach(c -> {
                System.out.printf("-%s -> %s%n", c.getKey(), c.getValue());
            });
        });                         
    }
    private static String getAverageStats(Map<String, Stats> map) {
        double averageDamage = 0;
        double averageHealth = 0;
        double averageArmor = 0;

        for (Stats d: map.values()) {
            averageDamage += d.getDamage();
            averageHealth += d.getHealth();
            averageArmor += d.getArmor();
        }
        averageDamage /= map.size();
        averageHealth /= map.size();
        averageArmor /= map.size();
        return String.format("(%.2f/%.2f/%.2f)", averageDamage, averageHealth, averageArmor);
    }


}
