package com.ccclubs.storage.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @auther FengJun
 * Date: 2017/9/29
 * Time: 14:45
 * Email:fengjun@ccclubs.com
 */
public class ConvertUtils {
    private static Logger logger= LoggerFactory.getLogger(ConvertUtils.class);
    public static Long convertToLong(Short param) {
        Long result = null;
        try {
            result = param.longValue();
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static Long convertToLong(Integer param) {
        Long result = null;
        try {
            result = param.longValue();
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static String convertToString(Integer param) {
        String result = null;
        try {
            result = String.valueOf(param);
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static String convertToString(Double param) {
        String result = null;
        try {
            result = String.valueOf(param);
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static String convertToString(Float param) {
        String result = null;
        try {
            result = String.valueOf(param);
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static String convertToString(Long param) {
        String result = null;
        try {
            result = String.valueOf(param);
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static String convertToString(Byte param) {
        String result = null;
        try {
            result = String.valueOf(param);
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static Integer convertToInterger(Short param) {
        Integer result = null;
        try {
            result = param.intValue();
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static Integer convertToInterger(Byte param) {
        Integer result = null;
        try {
            result = param.intValue();
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static Integer convertToInterger(String param) {
        Integer result = null;
        try {
            if (null != param && !param.isEmpty()) {
                result = Integer.valueOf(param);
            } else {
                return result;
            }
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static Float convertToFloat(Byte param) {
        Float result = null;
        try {
            result = param.floatValue();
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static Float convertToFloat(Integer param) {
        Float result = null;
        try {
            result = param.floatValue();
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

    public static Float convertToFloat(String param) {
        Float result = null;
        try {
            result = Float.valueOf(param);
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }


    public static Float convertToFloat(Short param) {
        Float result = null;
        try {
            result = param.floatValue();
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }


    public static Double convertToDouble(BigDecimal param) {
        Double result = null;
        try {
            result = param.doubleValue();
        } catch (NullPointerException e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        } catch (Exception e) {
            logger.info("Storage-模块转换方法值{}异常：{}",param,e.getMessage());
        }
        return result;
    }

}
