/*
package fr.abes.indexationsolr.services;

import fr.abes.indexationsolr.sujets.entities.DocumentSujets;
import fr.abes.indexationsolr.sujets.repositories.SujetsRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Component
@Getter
@Setter
@ComponentScan(basePackages = {"fr.abes.indexationsolr.services","fr.abes.indexationsolr.sujets.repositories"})
public class IndexationInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LogManager.getLogger(IndexationInterceptor.class);

    private String contexte;
    private String iddoc;
    private IndexationSolrSujet indexationSolrSujet;




    public IndexationInterceptor() {
    }

    public IndexationInterceptor(String contexte, String iddoc, IndexationSolrSujet indexationSolrSujet) {
        this.contexte = contexte;
        this.iddoc = iddoc;
        this.indexationSolrSujet = indexationSolrSujet;

    }

    @Override
    public boolean preHandle(HttpServletRequest requestServlet, HttpServletResponse responseServlet, Object handler) throws Exception
    {

        logger.info("MINIMAL: INTERCEPTOR PREHANDLE CALLED");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        logger.info("MINIMAL: INTERCEPTOR POSTHANDLE CALLED");
        this.iddoc = request.getParameter("iddoc");
        this.contexte = request.getParameter("contexte");
        response.setStatus(200);


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
    {
        System.out.println("MINIMAL: INTERCEPTOR AFTERCOMPLETION CALLED");
        logger.info("afterCompletion contexte : " + this.contexte);
        logger.info("response commited? " + response.isCommitted());

        if(this.contexte.contains("sujets")) {
            logger.info("ici");
            final String uri = "http://cirse1-dev.v3.abes.fr:8128/indexationsolr/LaunchingIndexationSolr?iddoc=4722";

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            */
/*this.indexationSolrSujet = new IndexationSolrSujet();
            this.indexationSolrSujet.setIddoc(Integer.parseInt(this.iddoc));
            this.indexationSolrSujet.setCheminXsl("file:///C:/Users/charalambou/IdeaProjects/indexationsolr/src/main/resources/sujets2solr.xsl");
            this.indexationSolrSujet.setUrlSolr("http://denim-dev.v102.abes.fr:8080/solrSujets/update");
            this.indexationSolrSujet.setTef(this.sujetsRepository.getTefByIddoc(Integer.parseInt(this.iddoc)));
            this.indexationSolrSujet.indexation();*//*

        }
        else if(this.contexte.contains("star")) {
            //IndexationSolrStar indexationSolrStar = (IndexationSolrStar) ctx.getBean("IndexationSolrStar");
            //indexationSolrStar.setIddoc(Integer.parseInt(this.iddoc));
            //indexationSolrStar.indexation();
        }
        else {
            //IndexationSolrPortail indexationSolrPortail = (IndexationSolrPortail) ctx.getBean("IndexationSolrPortail");
            //indexationSolrPortail.setIddoc(Integer.parseInt(this.iddoc));
            //indexationSolrPortail.indexation();
        }
    }
}
*/