package fr.abes.indexationsolr.services;

import fr.abes.indexationsolr.star.repositories.StarRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


@Service
public class IndexationSolrStar extends IndexationSolr {

    private Logger logger = LogManager.getLogger(IndexationSolrStar.class);

    @Autowired
    private Environment env;

    @Autowired
    private StarRepository starRepository;


    IndexationSolrStar() {
        super();
    }

    //@Transactional(transactionManager="starTransactionManager")
    public boolean indexation() throws Exception {

        boolean res = false;
        try {
            setUrlSolr(env.getProperty("urlSolrStar"));
            setCheminXsl(env.getProperty("cheminXsl.star"));
            setTef(starRepository.getTefByIddoc(this.getIddoc()));
            logger.info(("this.getTef()" + this.getTef()));
            if (indexerDansSolr(this.getIddoc(), this.getTef())) {
                res = true;
            }
            logger.info("res dans indexation = " + res);
        } catch (Exception e) {
            logger.info("Erreur dans indexation :"+e.getMessage());
            throw new Exception(e);
        }
        return res;
    }

    public boolean suppression(int iddoc) throws Exception {

        boolean res = false;
        try {
            setUrlSolr(env.getProperty("urlSolrStar"));
            setCheminXsl(env.getProperty("cheminXsl.star"));
            if (supprimerDeSolr(iddoc)) {
                res = true;
            }
            logger.info("res dans suppression = " + res);
        } catch (Exception e) {
            logger.info("Erreur dans suppression :"+e.getMessage());
            throw new Exception(e);
        }
        return res;
    }
}