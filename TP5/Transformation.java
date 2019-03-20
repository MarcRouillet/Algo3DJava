package TP5;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;



/**
 *La classe Transformation permet de factoriser le code dommun aux classes filles Translation, Rotation et Echelle.
 *Les fonctions communes � ses transformations sont principalement l'empilement et le d�pilement de matrices
 * @author Alexis Heloir
 * @version 20/03/2019
 */
public abstract class Transformation extends Noeud
{
    /**
    * Constructeur de la classe Transformation
    */
    public Transformation(Noeud _parent)
    {
        super(_parent);
    }
    
    public void afficher()
    {
        //On empile la matrice courante
        GL11.glPushMatrix();
        
        //On ex�cute la transformation de la classe.
        //M�me si on ne sait pas encore de quelle transformation il s'agit
        
        
        //On dessine le contenu de tous les �lements de cette classe 
        //Plus le contenu des noeuds enfants 
        //Il s'agit de parcourir le contenu du Vecteur contenant les enfants
        //Et d'appeler la m�thode afficher() pour chaque enfant r�f�renc� dans le vecteur        
        for (int i=0; i<m_enfants.size(); i++)
        {
            m_enfants.get(i).afficher();
        }
        
        //On d�pile la matrice courante
        GL11.glPopMatrix();
    }    
}
