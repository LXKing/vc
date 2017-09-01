package com.ccclubs.protocol.dto.mqtt;

public abstract class RemoteParam implements java.io.Serializable {

	private static final long serialVersionUID = 8606496725861551071L;

	public RemoteParam() {
	}

	public abstract Object[] getParamArray();

	public static class SetAirConditioning extends RemoteParam {

		private static final long serialVersionUID = 4618175808047661318L;
		byte r1 = 0;
		byte r2 = 0;

		/**
		 * @param circul 0:内循环 1:外循环
		 * @param ptc 0:关 1:开
		 * @param compre 压缩机 0:关 1:开
		 * @param fan 风量 0到4档
		 */
		public SetAirConditioning(byte circul, byte ptc, byte compre, byte fan) {
			this.r2 = (byte) (this.r2 | (circul));
			this.r2 = (byte) (this.r2 | (ptc << 1));
			this.r2 = (byte) (this.r2 | (compre << 2));
			this.r2 = (byte) (this.r2 | (fan << 3));
			this.r1 = 5;
		}

		/**
		 * @param type 01-内外循环模式，02- PTC启停信号，03-压缩机启停信号，04-风量
		 * @param value 对应上面函数的值
		 */
		public SetAirConditioning(byte type, byte value) {
			this.r1 = type;
			if (type == 1)
				this.r2 = (byte) (this.r2 | (value));
			if (type == 2)
				this.r2 = (byte) (this.r2 | (value << 1));
			if (type == 3)
				this.r2 = (byte) (this.r2 | (value << 2));
			if (type == 4)
				this.r2 = (byte) (this.r2 | (value << 3));
		}

		@Override
		public Object[] getParamArray() {
			return new Object[] { r1, r2 };
		}
	}

	public static class SetGPSCoordinates extends RemoteParam {

		private static final long serialVersionUID = 5432557210395935079L;
		Short log2 = 0;
		Integer log4 = 0;
		Short lat2 = 0;
		Integer lat4 = 0;

		/**
		 * @param log
		 * @param lat
		 */
		public SetGPSCoordinates(Double log, Double lat) {
			log2 = log.shortValue();
			lat2 = lat.shortValue();
			log4 = Integer.parseInt(log.toString().split(".")[1]);
			lat4 = Integer.parseInt(lat.toString().split(".")[1]);
		}

		@Override
		public Object[] getParamArray() {
			return new Object[] { log2, log4, lat2, lat4 };
		}
	}

	public static class PowerSavingMode extends RemoteParam {

		private static final long serialVersionUID = -835430319778501468L;
		Byte type = 0;//0:正常，1：低功耗模式1，2：低功耗模式2
		Short unknow1 = 0x0474;
		Short unknow2 = 0x0002;
		Short second = 0;//休眠秒数

		/**
		 * @param type //0:正常，1：低功耗模式1，2：低功耗模式2
		 * @param second //休眠时间
		 */
		public PowerSavingMode(Byte type, Short second) {
			this.type = type;
			this.second = second;
		}

		@Override
		public Object[] getParamArray() {
			return new Object[] { type, unknow1, unknow2, second };
		}
	}
}
