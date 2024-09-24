import java.util.HashMap;
import java.util.Random;

public class Player {
    private String name;
    private HashMap<Stats, Integer> stats;
    private Random random;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.random = new Random();
    }

    public String getName() {
        return name;
    }

    public void attack(Enemy enemy) {
        if (enemy.evade()) {
            System.out.println(enemy.getName() + " esquivó el ataque de " + name + "!");
            return;
        }

        int baseDamage = getStat(Stats.ATTACK);
        if (isCriticalHit()) {
            baseDamage += 50; /*Golpe crítico*/
            System.out.println("¡Golpe crítico! " + name + " hace 50 de daño extra.");
        }

        int damageDealt = baseDamage - enemy.getStat(Stats.DEFENSE);
        damageDealt = Math.max(damageDealt, 0); /* El daño mínimo es 0*/

        /* Mostrar el mensaje del ataque
         */
        System.out.println(name + " ataca a " + enemy.getName() + " causando " + damageDealt + " de daño.");

        enemy.takeDamage(damageDealt); /* Aplicar el daño*/
    }

    public void takeDamage(int damage) {
        int hp = getStat(Stats.HP) - damage;
        setStat(Stats.HP, Math.max(hp, 0)); /* No puede tener HP negativo*/
    }

    public boolean isAlive() {
        return getStat(Stats.HP) > 0;
    }

    public boolean evade() {
        int evasionChance = getStat(Stats.EVASION);
        int roll = random.nextInt(100); /* Genera un número entre 0 y 99*/
        return roll < evasionChance; /* Esquiva si el roll es menor a la evasión*/
    }

    public boolean isCriticalHit() {
        int critChance = getStat(Stats.CRITICAL_HIT_CHANCE) + getStat(Stats.LUCK);
        int roll = random.nextInt(100); /* Genera un número entre 0 y 99*/
        return roll < critChance; /* Golpe crítico si el roll es menor a la chance*/
    }

    public void setStat(Stats stat, int value) {
        stats.put(stat, value);
    }

    public int getStat(Stats stat) {
        return stats.getOrDefault(stat, 0);
    }
}
