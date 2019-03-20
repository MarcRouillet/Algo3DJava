package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;


/**
 * La classe spot repr�sente une lumi�re ponctuelle qui
 * diffuse un faisceau de lumi�re selon une direction
 * et un angle de diffusion (GL_SPOT_CUTOFF). Un troisi�me param�tre
 * (GL_SPOT_EXPONENT) d�termine l'att�nuation de l'intensit� lumineuse
 * lorsque la direction des rayons s'�carte de la direction principale
 * (GL_SPOT_DIRECTION)
 *
 * @author Alexis Heloir
 * @version 19/03/2019
 */
public class LumiereSpot extends LumierePonctuelle
{
    //La direction principale de la lumi�re spot (tableau de r�els, dimension 1)
    float[] m_spotDirection = {0.0f, 0.0f, -1.0f};
    
    //L'angle de diffusion de la lumi�re spot
    //(r�el compris entre 0 (distribution uniforme) et 128 (focus maximal) )
    float m_spotCutoff = 0.0f;
    
    //L'att�nuation par rapport � la direction principale
    //(r�el entre 0 et 90 => C�ne de lumi�re ou 180 => Distribution uniforme)
    float m_spotExponent = 90.0f;    

    /**
     * Constructeur de la classe LumiereSpot
     * @param _vecteurAmbiant composante ambiante de la lumi�re
     * @param _vecteurDiffus composante diffus de la lumi�re
     * @param _vecteurSpeculaire composante speculaire de la lumi�re
     * @param _position vectur donnant la direction des rayons �mis
     * @param _spotDirection donnant la direction principale de la lumi�re
     * @param _spotCutoff donnant l'angle de la diffusion de la lumi�re
     * @param _spotExponent donnant l'att�nuation par rapport � la direction principale
     */
    public LumiereSpot(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                       Vecteur3D _vecteurSpeculaire, Vecteur3D _position, Vecteur3D _spotDirection, float _spotCutoff, float _spotExponent)
                       {
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire, _position);
        m_spotDirection[0] = _spotDirection.getX();
        m_spotDirection[1] = _spotDirection.getY();
        m_spotDirection[3] = -1.0f;
        
        m_spotCutoff = _spotCutoff;
        
        m_spotExponent = _spotExponent;       
        
    }

    /**
     * Constructeur sans param�tre de la classe LumiereSpot
     */
    public LumiereSpot()
    {
        m_spotDirection[0] = 0.0f;
        m_spotDirection[1] = 0.0f;
        m_spotDirection[3] = -1.0f;
        
        m_spotCutoff = 0.0f;
        
        m_spotExponent = 90.0f;    
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_spotDirection);
        buffDirection.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffDirection);        
        GL11.glLightf(m_currentLight, GL11.GL_SPOT_CUTOFF, m_spotCutoff);        
        GL11.glLightf(m_currentLight, GL11.GL_SPOT_EXPONENT, m_spotExponent);
    }
}
