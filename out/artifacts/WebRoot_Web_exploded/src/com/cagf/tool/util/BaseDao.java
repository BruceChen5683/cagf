package com.cagf.tool.util;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class BaseDao<T> extends HibernateDaoSupport {
    
    protected void removeObj(Class<T> c, Serializable id){
        T obj = this.getHibernateTemplate().get(c,id);
        this.getHibernateTemplate().delete(obj);
    }
        
    protected void removeObjs(Class<T> c, List<Long> ids){
        for(Long id : ids){
        	this.removeObj(c, id);
        }
    }
    
    protected void updateObj(T obj){
    	this.getHibernateTemplate().saveOrUpdate(obj);
    }
    
    protected void updateObjs(List<T> objs) {
		this.getHibernateTemplate().saveOrUpdateAll(objs);
	}
    
    protected T retrieveObj(Class<T> c,Serializable id){
        return (T)this.getHibernateTemplate().get(c,id);
    }
    
	protected List<T> retrieveObjs(String queryString){
        return (List<T>) this.getHibernateTemplate().find(queryString);
    }
    
    protected List<T> retrieveObjs(String queryString,String... value){
        return (List<T>) this.getHibernateTemplate().find(queryString,value);
    }


    /**
     * 分页查询
     * @param queryString
     * @param values
     * @param start
     * @param number
     * @return
     */
    protected List<T> retrieveObjs(final String queryString,final String[] values,final int start,final int number){
    	
        return this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

            @Override
            public List<T> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(queryString);
                
                for (int i = 0;i < values.length;i++){
                    query = query.setString(i,values[i]);
                }
                
                query.setFirstResult(start);
                query.setMaxResults(number);
                
                return query.list();
            }
        });
    }

    protected List<T> retrieveObjs(final String queryString,final String value,final int start,final int number) {
        String[] values = {value};
        return this.retrieveObjs(queryString,values,start,number);
    }

    protected T retrieveObj(String queryString,String... value){
        List<T> objs = this.retrieveObjs(queryString,value);

        if (null != objs && objs.size() > 0){
            return objs.get(0);
        }
        return null;
    }

    protected T retrieveObj(String queryString){
        return (T) this.getHibernateTemplate().find(queryString);
    }

    protected long retrieveObjsCount(final String queryString,final String... values){
        Object count = this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select count(*) "+queryString);
                for (int i = 0;i < values.length;i++){
                    query = query.setString(i,values[i]);
                }
                return query.iterate().next();
            }
        });

        return (Long) count;
    }

    protected long retrieveObjsCount(final String queryString){
        String[] values = new String[0];
        return retrieveObjsCount(queryString,values);
    }

    protected void storeObj(T obj){
        this.getHibernateTemplate().save(obj);
//        this.getHibernateTemplate().saveOrUpdate(obj);
    }

    //   saveOrUpdateAll
    protected void storeObjs(List<T> objs){
        for (T obj:objs){
            storeObj(obj);
        }
    }


    
    
}
