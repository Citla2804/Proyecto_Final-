public class Main {
    public static void main(String[] args) {

        /* Crear jugador y enemigo
         */
        Player player = new Player("Godofredo");
        Enemy enemy = new Enemy("Mago Oscuro");

        /*Asignar estadísticas al jugador
         */
        player.setStat(Stats.HP, 100);
        player.setStat(Stats.MAX_HP, 100);
        player.setStat(Stats.ATTACK, 5);
        player.setStat(Stats.DEFENSE, 0);
        player.setStat(Stats.SPEED, 5);
        player.setStat(Stats.EVASION, 8);
        player.setStat(Stats.LUCK, 5);
        player.setStat(Stats.CRITICAL_HIT_CHANCE, 5);

        /* Asignar estadísticas al enemigo
         */
        enemy.setStat(Stats.HP, 100);
        enemy.setStat(Stats.MAX_HP, 100);
        enemy.setStat(Stats.ATTACK, 15);
        enemy.setStat(Stats.DEFENSE, 4    );
        enemy.setStat(Stats.SPEED, 4);
        enemy.setStat(Stats.EVASION, 3);
        enemy.setStat(Stats.LUCK, 3);
        enemy.setStat(Stats.CRITICAL_HIT_CHANCE, 2);

        /*Crear el juego
         */
        Game game = new Game(player, enemy);

        /*Iniciar el juego
         */
        game.startGame();
    }
}