package edu.cpp.cs.cs141.final_project;

/**
 * CS 141: Intro to Programming and Problem Solving Professor: Edwin Rodriguez
 *
 * Final Project: Spy Game
 *
 * Create a small, yet interesting, text-based game involving a spy and ninjas.
 *
 * Team Magic!~<3 Diana Choi, William Hang, Logan Carichner, Robert Delfin, Mora
 * Labisi
 */
public class ActiveAgent {
	private boolean alive;
	private String agentName;
	private int agentHealth;
	private int ammo;
	private boolean hasRadar;
	private boolean isInvulnerable;
	private boolean isPlayer;

	/**
     * The following integers represent the player's x and y coordinates
     */
    private int row;
	private int column;

	/**
	 * This constructor takes no arguments and creates an enemy ninja assassin.
	 */
	public ActiveAgent() {
		alive = true;
		agentName = "Ninja Assassin";
		agentHealth = 1;
		isPlayer = false;
		isInvulnerable = false;
	}

	/**
	 * This constructor takes a string argument and creates a player character.
	 * 
	 * @param name
	 *            the name of the character
	 */
	public ActiveAgent(String name) {
		alive = true;
		agentName = name;
		agentHealth = 3;
		ammo = 1;
		isInvulnerable = false;
		hasRadar = false;
		isPlayer = false;

		if (agentName.compareToIgnoreCase("player") == 0){
			isPlayer =  true;
		}
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	/**
	 * This method deals an amount of damage to the agent's HP.
	 * 
	 * @param x
	 *            the amount of damage
	 */
	public void takeDamage(int x) {
		agentHealth -= x;
		checkAlive();
	}

	/**
	 * This method checks the Agent's health and sets it's alive marker to false
	 * if they have 0 or less health
	 */
	public void checkAlive() {
		if (agentHealth <= 0)
			alive = false;
	}

	/**
	 * This method asks the agent where it wants to move.
	 *
	 *            a string representing a direction of movement
	 */
	public int agentMove() {
		int direction = Engine.roll(4);
		return direction;
	}

	public int getAmmo(){
		return ammo;
	}

	public void incAmmo(){
		if(ammo == 0)
			++ammo;
	}

	public boolean hasAmmo(){
		if(ammo == 1)
			return true;
		return false;
	}

	public void toggleIsInvulnerable(){
		isInvulnerable = !isInvulnerable;
	}

	public void toggleHasRadar(boolean value){
		hasRadar = !hasRadar;
	}

	public boolean checkHasRadar(){
		return hasRadar;
	}

	public void setRow(int value){
	    row = value;
    }

    public void setColumn(int value){
	    column = value;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

}
