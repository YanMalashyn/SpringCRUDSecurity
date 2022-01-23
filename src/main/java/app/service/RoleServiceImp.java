package app.service;

import app.dao.RoleDao;
import app.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao){
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Transactional
    @Override
    public List<String> getAllRolesNamesStringArray() {
        return roleDao.getAllRolesNamesStringArray();
    }

    @Transactional
    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Transactional
    @Override
    public void deleteRoleById(Long id) {
        roleDao.deleteRoleById(id);
    }

    @Transactional
    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Transactional
    @Override
    public Role getByRoleName(String roleName) {
        return roleDao.getByRoleName(roleName);
    }
}
