public class Game {
    private Player player;
    private Enemy enemy;

    public Game(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startGame() {
        /* Mostrar las vidas antes de iniciar el combate*/
        showInitialHealth();

        System.out.println("El juego comienza entre " + player.getName() + " y " + enemy.getName());

        /* Ciclo de combate por turnos*/
        while (player.isAlive() && enemy.isAlive()) {
            if (player.getStat(Stats.SPEED) >= enemy.getStat(Stats.SPEED)) {
                /* El jugador ataca primero*/
                player.attack(enemy);
                /* Mostrar la vida restante del enemigo después del ataque*/
                System.out.println(enemy.getName() + " ahora tiene " + enemy.getStat(Stats.HP) + " HP.");

                if (enemy.isAlive()) {
                    enemy.attack(player);
                    /* Mostrar la vida restante del jugador después del ataque*/
                    System.out.println(player.getName() + " ahora tiene " + player.getStat(Stats.HP) + " HP.");
                }
            } else {
                /* El enemigo ataca primero*/
                enemy.attack(player);
                /* Mostrar la vida restante del jugador después del ataque*/
                System.out.println(player.getName() + " ahora tiene " + player.getStat(Stats.HP) + " HP.");

                if (player.isAlive()) {
                    player.attack(enemy);
                    /* Mostrar la vida restante del enemigo después del ataque*/
                    System.out.println(enemy.getName() + " ahora tiene " + enemy.getStat(Stats.HP) + " HP.");
                }
            }

            /* Checar si alguno ha muerto*/
            if (!enemy.isAlive()) {
                System.out.println("¡" + player.getName() + " gana!");
            } else if (!player.isAlive()) {
                System.out.println("Game Over. " + player.getName() + " ha sido derrotado.");
                askToPlayAgain();
            }
        }
    }

    /* Método para mostrar la vida inicial*/
    private void showInitialHealth() {
        System.out.println(player.getName() + " tiene " + player.getStat(Stats.HP) + " HP.");
        System.out.println(enemy.getName() + " tiene " + enemy.getStat(Stats.HP) + " HP.");
    }

    private void askToPlayAgain() {
        System.out.println("¿Quieres jugar de nuevo? (Sí = 1 / No = 0)");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int response = scanner.nextInt();

        if (response == 1) {
            resetGame();
            startGame();
        } else {
            System.out.println("Gracias por jugar.");
        }
    }

    private void resetGame() {
        /* Resetear las estadísticas para una nueva partida*/
        player.setStat(Stats.HP, player.getStat(Stats.MAX_HP));
        enemy.setStat(Stats.HP, enemy.getStat(Stats.MAX_HP));
        System.out.println("¡El juego ha sido reiniciado!");
    }
}
