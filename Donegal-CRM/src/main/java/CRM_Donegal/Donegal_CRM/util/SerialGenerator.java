package CRM_Donegal.Donegal_CRM.util;

import java.util.concurrent.atomic.AtomicInteger;

public class SerialGenerator {
    private final AtomicRangeInteger atomicRangeInteger = new AtomicRangeInteger(0, 1 << 31 - 1);

    public long getSerialId() {
        final long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis << 32 | atomicRangeInteger.getAndIncrrment();
    }
}

class AtomicRangeInteger
{
    private final int maxValue;
    private final AtomicInteger atomicInteger;

    public AtomicRangeInteger(final int minValue, final int maxValue)
    {
        this.atomicInteger = new AtomicInteger(minValue);
        this.maxValue = maxValue;
    }

    public Integer getAndIncrrment()
    {
        final int value = this.atomicInteger.incrementAndGet();
        if (value > maxValue)
        {
            return null;
        }

        return value;
    }
}
