package TP5;

import TP4.Vecteur3D;
import org.lwjgl.opengl.GL11;


/**
 * Write a description of class Rotate here.
 *
 * @author Alexis Heloir
 * @version 20/03/2019
 */
public class Echelle extends Transformation
{
    Vecteur3D m_echelle;      
    
    /**
     * Constructeur de la classe Echelle
     * 
     * @param _parent le noeud d�clar� comme parent de l'instance courante (this)
     * @param _coordonnees les coordonn�es de la mise � l'�chelle � appliquer
     */
    public Echelle(Noeud _parent, Vecteur3D _echelle)
    {   
        super(_parent);
        m_echelle = _echelle;        
    }
    
    /**
     * Impl�mentation de la m�thode abstraite transforme() d�clar�e initialement dans la
     * classe Echelle. Elle consiste � appeler l'instruction OpenGL
     * glScalef avec trois coordonnees (float)
     */
    public void transforme()
    {
         GL11.glScalef(m_echelle.getX(), m_echelle.getY(), m_echelle.getZ());
    }    
}
