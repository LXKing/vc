package com.ccclubs.frm.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author Joel
 * @create 2017-8-11
 */
public abstract class CrudService<D extends BaseDAO<T, PK>, T, PK> implements BaseService<T, PK> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
	 * 持久层对象
	 */
    @Autowired
	protected D dao;
//
    public D getDao() {
        return dao;
    }

    public void setDao(D dao) {
		this.dao = dao;
	}
//
//    /**
//	 * 获取单条数据
//	 * @param id
//	 * @return
//	 */
//	@Override
//	public T get(PK id) {
//		return dao.selectByPrimaryKey(id);
//	}
//
//	@Override
//	public T get2(PK id) {
//		return dao.selectById(id);
//	}
//
//
//    /**
//	 * 保存数据（插入或更新）
//	 * @param t
//	 */
//	@Override
//	public int save(T t) {
//		return dao.insert(t);
//	}
//
//    /**
//	 * 保存数据（插入或更新）
//	 * @param ts
//	 */
//	@Override
//	public int batchSave(List<T> ts) {
//        return dao.batchInsert(ts);
//	}
//
//
//    @Override
//    public int delete(T t) {
//        return dao.delete(t);
//    }
//
//    @Override
//    public int deleteById(PK id) {
//        return dao.deleteByPrimaryKey(id);
//    }
//
//
	@Override
	public List<T> getAll() {
		return dao.selectAll();
	}

	@Override
	public List<T> getAllByParam(Object t) {
		logger.debug("BankCrudService query all start param: t = {}", t);
		List<T> results = null;
		try {
			results = dao.selectByExample(t);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			logger.error("Exception BankCrudService query all error: {}", sw.toString());
		}
		logger.debug("BankCrudService query all end");
		return results;
	}

	@Override
	public PageInfo<T> getPage(Object t, int pageNum, int pageSize) {
		logger.debug("BankCrudService queryPage start param: t = {}", t);
		List<T> results = null;
		try {
			//分页查询
			PageHelper.startPage(pageNum, pageSize);
        	//results = dao.selectByParam(t);
			results = dao.selectByExample(t);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("Exception BankCrudService queryPage error: {}", sw.toString());
		}
		logger.debug("BankCrudService queryPage end");
		return new PageInfo<>(results);
	}

//	@Override
//	public int batchInsert(List<T> ts) {
//		return dao.batchInsert(ts);
//	}
//
//	@Override
//	public List<T> selectByParam(T t) {
//		return dao.selectByParam(t);
//	}
//
//	@Override
//	public int countTotal(T t) {
//		return dao.countTotal(t);
//	}
//
//	@Override
//	public T selectById(PK id) {
//		return dao.selectById(id);
//	}

	@Override
	public int batchDelete(Object[] ids) {
		if(ids == null) {return 0;}
		
		int count = 0;
		for(Object id : ids){
			count += dao.deleteByPrimaryKey(id);
		}
		return count;
	}

	@Override
	public int insertSelective(T record) {
		return dao.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int selectCountByExample(Object example) {
		return dao.selectCountByExample(example);
	}

	@Override
	public List<T> select(T record) {
		return dao.select(record);
	}

	@Override
	public int selectCount(T record) {
		return dao.selectCount(record);
	}

	@Override
	public int updateByExample(T record, Object example) {
		return dao.updateByExample(record, example);
	}

	@Override
	public boolean existsWithPrimaryKey(Object key) {
		return dao.existsWithPrimaryKey(key);
	}

	@Override
	public int updateByExampleSelective(T record, Object example) {
		return dao.updateByExampleSelective(record, example);
	}

	@Override
	public int deleteByPrimaryKey(Object key) {
		return dao.deleteByPrimaryKey(key);
	}

	@Override
	public int delete(T record) {
		return dao.delete(record);
	}

	@Override
	public T selectOne(T record) {
		return dao.selectOne(record);
	}

	@Override
	public List<T> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<T> selectByExampleAndRowBounds(Object example,
			RowBounds rowBounds) {
		return dao.selectByExampleAndRowBounds(example, rowBounds);
	}

	@Override
	public T selectByPrimaryKey(Object key) {
		return dao.selectByPrimaryKey(key);
	}

	@Override
	public List<T> selectByExample(Object example) {
		return dao.selectByExample(example);
	}

	@Override
	public int insertList(List<T> recordList) {
		return dao.insertList(recordList);
	}

	@Override
	public int deleteByExample(Object example) {
		return dao.deleteByExample(example);
	}

	@Override
	public int insert(T record) {
		return dao.insert(record);
	}

	@Override
	public int insertUseGeneratedKeys(T record) {
		return dao.insertUseGeneratedKeys(record);
	}

	@Override
	public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
		return dao.selectByRowBounds(record, rowBounds);
	}
	
}
