
package tp0;

public class Data 
{
    
    private final String id;
    private final String data;
    private String commentaires;
    
    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
    
    /**
     * Le constructeur avec un builder
     * @param db 
     */
    public Data(DataBuilder db) {
        id=db.id;
        data=db.data;
        commentaires=db.commentaires;
    }

    /**
     * Une classe builder interne (et static)
     * a utiliser par new Data.DataBuilder(___).attribut1(_)....build();
     */
    public static class DataBuilder {

        /**
         * Ide de la data (obligatoire)
         */
        String id;
        /**
         * Donne de la data (obligatoire)
         */
        String data;
        /**
         * Commentaire (option)
         */
        String commentaires;
        
        /** 
         * Constructeur minimal du pattern Builder 
         * est la Liste des attributs obligatoires
         * @param id
         * @param data 
         */
        public DataBuilder(String id,String data) {
            id=id;
            data=data;
        }
        /**
         * Paramètre de build tout attribut optionnel renvoi un builder
         * @param commentaire
         * @return un DataBuilder pour enchaîner les mise a jour du builder
         */
        public DataBuilder commentaire(String commentaire) {
            commentaires=commentaire;
            return this;
        }
        
        /**
         * Le build
         * @return objet à créer
         */
        public Data build(){
            return new Data(this);
        }
    }
}

