package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {
    private Project project1E1;
    private Project project1E2;
    private Project project2E1;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;


    /**
     * this method initialize the projects and enterprises
     * with the @Transactional if one project or enterprise fail the whole method fail.
     */
    @Transactional
    public void initProjects() {
        this.enterprise1 = enterpriseProjectService.newEnterprise("entreprise1", "enterprise 1", "fantin", "fantin@email.com");
        this.enterprise2 = enterpriseProjectService.newEnterprise("entrepriseZ", "enterprise 2", "martin", "martin@email.com");

        this.project1E1 = enterpriseProjectService.newProject("project1e1", "project 1 enterprise 1", this.enterprise1);
        this.project1E2 = enterpriseProjectService.newProject("project1e2", "project 1 enterprise 2", this.enterprise2);
        this.project2E1 = enterpriseProjectService.newProject("project2e1", "project 2 enterprise 1", this.enterprise1);
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }
}
