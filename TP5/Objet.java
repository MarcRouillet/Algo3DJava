package TP5;


/**
 * Write a description of class Objet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Objet extends Noeud
{
    public Objet(Noeud _parent)
    {
        super(_parent);
    }

    public abstract void dessiner();   
    
    public void afficher()
    {
        /*
         *Ici on dessine l'objet, m�me si on ne sais pas comment le dessiner. 
         */
        dessiner();
        
        /*
         * Ici on dessine le contenu de tous les �l�ments de cette classe, plus le contenu des noeuds enfants.
         * Il s'agit de parcourir le contenu du Vecteur contenant les enfants et d'appeler la m�thode afficher()
         * pour chaque enfant r�f�renc� dans le vecteur
         */
        for (int i=0; i<m_enfants.size(); i++)
        {
            m_enfants.get(i).afficher();
        }
    }
}
