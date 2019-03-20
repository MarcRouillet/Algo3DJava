package TP5;

import TP4.Vecteur3D;
import org.lwjgl.opengl.GL11;


/**
 * Write a description of class Rotate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rotation extends Transformation
{
    //Ce vecteur stocke les coordonn�es de rotate
    private Vecteur3D m_axe;
    private float m_angle;
    
    /**
     * Constructeur par d�faut de la classe Rotation
     * @param _parent le noeud d�clar� comme parent de l'instance courante (this)
     * @param _coordonnees les coordonn�es de la rotation � appliquer
     * @param _angle l'angle de la rotation
     */
    public Rotation(Noeud _parent, Vecteur3D _axe, float _angle)
    {
        super(_parent);
        m_angle = _angle;
        m_axe = _axe;
    }
    
    /**
     * Impl�mentation de la m�thode transforme sur la classe Rotation. Rotatef est une fonction qui prend en entr�e l'angle et les trois 
     * coordonn�es du Vecteur3D axe
     */
    public void transforme()
    {
        GL11.glRotatef(m_angle, m_axe.getX(), m_axe.getY(), m_axe.getZ());
    }
}
