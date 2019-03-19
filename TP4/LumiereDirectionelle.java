package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Une lumi�re directionnelle repr�sente une source de lumi�re
 * situ�e � l'infini : tous les rayons �mis par cette lumi�re sont parall�les
 * et leur direction est donn�e par un vecteur.
 * @author Alexis Heloir
 * @version 19/03/2019
 */
public class LumiereDirectionelle extends Lumiere
{

    private float[] m_direction = {0.0f,0.0f,0.0f,0.0f};
    
    /**
     * Constructeur de la classe LumiereDirectionnelle, il prend quatre arguments
     * @param _vecteurAmbiant composante ambiante de la lumi�re
     * @param _vecteurDiffus composante diffus de la lumi�re
     * @param _vecteurSpeculaire composante speculaire de la lumi�re
     * @param _direction direction de la lumi�re. 
     */
    public LumiereDirectionelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _direction)
    {
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
        m_direction[0] = _direction.getX();
        m_direction[1] = _direction.getY();
        m_direction[2] = _direction.getZ();
        m_direction[3] = 0.0f; //La derni�re valeur du tableau du r�el repr�sentant la position est
                                // �gale � 0 pour indiquer que la lumi�re est directionnelle (c'est dans la doc
    }
    
    /**
     * Constructeur sans param�tre pour la classe Lumi�reDirectionelle
     * Il place une lumi�re directionelle qui simule une lumi�re d'un b� soleil de z�nith. 
     */
    public LumiereDirectionelle()
    {
        m_direction[0] = 0.0f;
        m_direction[1] = 0.0f;
        m_direction[2] = 0.0f;
        m_direction[3] = 0.0f;
    }
    
    /**
     * On initialise la valeur du vecteur de direction pour cette instance de classe 
     * de lumi�re directionelle apr�s avoir appel� la m�thode d'initialisation de la 
     * classe parente
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_direction);
        buffDirection.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffDirection);
        
    }

}
