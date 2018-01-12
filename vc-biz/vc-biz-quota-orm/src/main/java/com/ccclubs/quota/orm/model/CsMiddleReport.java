package com.ccclubs.quota.orm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/3 0003.
 */
public class CsMiddleReport implements Serializable{

        private static final long serialVersionUID =         1L;

        /**
         * [csmr_vin]车辆VIN码
         */

        private   String csmrVin;
        /**
         * [csmr_number]车机号
         */

        private   String csmrNumber;
        /**
         * [csmr_car_no]真实车牌:
         */

        private   String csmrCarNo;
        /**
         * [csmr_model]车辆类型
         */

        private   Integer csmrModel;
        /**
         * [csmr_obd_mile]累计里程
         */

        private   BigDecimal csmrObdMile;
        /**
         * [csmr_exception_mile]异常里程
         */

        private   BigDecimal csmrExceptionMile;
        /**
         * [csmr_mile_state]数据状态： 1=异常， 2= 正常
         */

        private   Short csmrMileState;
        /**
         * [csmr_status]cs_vin 1= 不是当前数据， 2=当前加的数据
         */

        private   Short csmrStatus;
        /**
         * [csmr_domain]车辆领域：0:未知,1:个人领域,2:公共领域
         */

        private   Short csmrDomain;
        /**
         * [csmr_add_time]添加时间
         */
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
        private   Date csmrAddTime;
        /**
         * [csmr_prod_time]车辆出厂日期
         */
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
        private   Date csmrProdTime;
        /**
         * [csmr_sale_time]车辆销售时间
         */
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
        private   Date csmrSaleTime;

        //默认构造函数
        public CsMiddleReport(){

        }
        /*******************************编号**********************************/
        /**
         * 编号 [非空]
         **/

        /*******************************车辆VIN码**********************************/
        /**
         * 车辆VIN码 [可空]
         **/
        public String getCsmrVin(){
            return this.csmrVin;
        }

        /**
         * 车辆VIN码 [可空]
         **/
        public void setCsmrVin(String csmrVin){
            this.csmrVin = csmrVin;
        }
        /*******************************车机号**********************************/
        /**
         * 车机号 [可空]
         **/
        public String getCsmrNumber(){
            return this.csmrNumber;
        }

        /**
         * 车机号 [可空]
         **/
        public void setCsmrNumber(String csmrNumber){
            this.csmrNumber = csmrNumber;
        }
        /*******************************真实车牌:**********************************/
        /**
         * 真实车牌: [可空]
         **/
        public String getCsmrCarNo(){
            return this.csmrCarNo;
        }

        /**
         * 真实车牌: [可空]
         **/
        public void setCsmrCarNo(String csmrCarNo){
            this.csmrCarNo = csmrCarNo;
        }
        /*******************************车辆类型**********************************/
        /**
         * 车辆类型 [可空]
         **/
        public Integer getCsmrModel(){
            return this.csmrModel;
        }

        /**
         * 车辆类型 [可空]
         **/
        public void setCsmrModel(Integer csmrModel){
            this.csmrModel = csmrModel;
        }
        /*******************************累计里程**********************************/
        public BigDecimal getCsmrObdMile() {
                return csmrObdMile;
        }

        public void setCsmrObdMile(BigDecimal csmrObdMile) {
                this.csmrObdMile = csmrObdMile;
        }

        public BigDecimal getCsmrExceptionMile() {
                return csmrExceptionMile;
        }

        public void setCsmrExceptionMile(BigDecimal csmrExceptionMile) {
                this.csmrExceptionMile = csmrExceptionMile;
        }


        /*******************************数据状态： 1=异常， 2= 正常**********************************/
        /**
         * 数据状态： 1=异常， 2= 正常 [可空]
         **/
        public Short getCsmrMileState(){
            return this.csmrMileState;
        }

        /**
         * 数据状态： 1=异常， 2= 正常 [可空]
         **/
        public void setCsmrMileState(Short csmrMileState){
            this.csmrMileState = csmrMileState;
        }
        /*******************************cs_vin 1= 不是当前数据， 2=当前加的数据  **********************************/
        /**
         * cs_vin 1= 不是当前数据， 2=当前加的数据   [可空]
         **/
        public Short getCsmrStatus(){
            return this.csmrStatus;
        }

        /**
         * cs_vin 1= 不是当前数据， 2=当前加的数据   [可空]
         **/
        public void setCsmrStatus(Short csmrStatus){
            this.csmrStatus = csmrStatus;
        }
        /*******************************车辆领域：0:未知,1:个人领域,2:公共领域**********************************/
        /**
         * 车辆领域：0:未知,1:个人领域,2:公共领域 [可空]
         **/
        public Short getCsmrDomain(){
            return this.csmrDomain;
        }

        /**
         * 车辆领域：0:未知,1:个人领域,2:公共领域 [可空]
         **/
        public void setCsmrDomain(Short csmrDomain){
            this.csmrDomain = csmrDomain;
        }
        /*******************************添加时间**********************************/
        /**
         * 添加时间 [可空]
         **/
        public Date getCsmrAddTime(){
            return this.csmrAddTime;
        }

        /**
         * 添加时间 [可空]
         **/
        public void setCsmrAddTime(Date csmrAddTime){
            this.csmrAddTime = csmrAddTime;
        }
        /*******************************车辆出厂日期**********************************/
        /**
         * 车辆出厂日期 [可空]
         **/
        public Date getCsmrProdTime(){
            return this.csmrProdTime;
        }

        /**
         * 车辆出厂日期 [可空]
         **/
        public void setCsmrProdTime(Date csmrProdTime){
            this.csmrProdTime = csmrProdTime;
        }
        /*******************************车辆销售时间**********************************/
        /**
         * 车辆销售时间 [可空]
         **/
        public Date getCsmrSaleTime(){
            return this.csmrSaleTime;
        }

        /**
         * 车辆销售时间 [可空]
         **/
        public void setCsmrSaleTime(Date csmrSaleTime){
            this.csmrSaleTime = csmrSaleTime;
        }

}
