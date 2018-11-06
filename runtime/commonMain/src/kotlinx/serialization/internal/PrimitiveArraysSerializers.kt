/*
 * Copyright 2017-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.serialization.internal

import kotlinx.serialization.*

private const val INITIAL_SIZE = 10

// it could be an object, but https://youtrack.jetbrains.com/issue/KT-14628
class ByteArraySerializer() :
    PrimitiveArraySerializer<Byte, ByteArray, ByteArraySerializer.Builder>(ByteSerializer, ByteDescriptor),
    KSerializer<ByteArray> {
    inner class Builder internal constructor() :
        PrimitiveArraySerializer<Byte, ByteArray, ByteArraySerializer.Builder>.Builder() {

        private var buf: ByteArray = ByteArray(INITIAL_SIZE)
        override var pos: Int = 0
            private set

        constructor(filledBuf: ByteArray): this() {
            buf = filledBuf
            pos = filledBuf.size
        }

        override fun ensureCapacity(requiredCapacity: Int) {
            if (buf.size < requiredCapacity)
                buf = buf.copyOf(requiredCapacity.coerceAtLeast(buf.size * 2))
        }

        internal fun append(c: Byte) {
            ensureCapacity()
            buf[pos++] = c
        }

        override fun build() = buf.copyOf(pos)
    }

    override fun ByteArray.objSize(): Int = size
    override fun builder(): Builder = Builder()
    override fun ByteArray.toBuilder(): Builder = Builder(this)

    override fun readItem(decoder: CompositeDecoder, index: Int, builder: Builder, checkIndex: Boolean) {
        builder.append(decoder.decodeByteElement(descriptor, index))
    }

    override fun writeContents(encoder: CompositeEncoder, content: ByteArray, size: Int) {
        for (i in 0 until size)
            encoder.encodeByteElement(descriptor, i, content[i])
    }

    companion object : KSerializer<ByteArray> by ByteArraySerializer()
}

// the rest of the serializers are merely copy-paste

class ShortArraySerializer() :
    PrimitiveArraySerializer<Short, ShortArray, ShortArraySerializer.Builder>(ShortSerializer, ShortDescriptor),
    KSerializer<ShortArray> {
    inner class Builder internal constructor() :
        PrimitiveArraySerializer<Short, ShortArray, ShortArraySerializer.Builder>.Builder() {

        private var buf: ShortArray = ShortArray(INITIAL_SIZE)
        override var pos: Int = 0
            private set

        constructor(filledBuf: ShortArray): this() {
            buf = filledBuf
            pos = filledBuf.size
        }

        override fun ensureCapacity(requiredCapacity: Int) {
            if (buf.size < requiredCapacity)
                buf = buf.copyOf(requiredCapacity.coerceAtLeast(buf.size * 2))
        }

        internal fun append(c: Short) {
            ensureCapacity()
            buf[pos++] = c
        }

        override fun build() = buf.copyOf(pos)
    }

    override fun ShortArray.objSize(): Int = size
    override fun builder(): Builder = Builder()
    override fun ShortArray.toBuilder(): Builder = Builder(this)

    override fun readItem(decoder: CompositeDecoder, index: Int, builder: Builder, checkIndex: Boolean) {
        builder.append(decoder.decodeShortElement(descriptor, index))
    }

    override fun writeContents(encoder: CompositeEncoder, content: ShortArray, size: Int) {
        for (i in 0 until size)
            encoder.encodeShortElement(descriptor, i, content[i])
    }
}

class IntArraySerializer() :
    PrimitiveArraySerializer<Int, IntArray, IntArraySerializer.Builder>(IntSerializer, IntDescriptor),
    KSerializer<IntArray> {
    inner class Builder internal constructor() :
        PrimitiveArraySerializer<Int, IntArray, IntArraySerializer.Builder>.Builder() {

        private var buf: IntArray = IntArray(INITIAL_SIZE)
        override var pos: Int = 0
            private set

        constructor(filledBuf: IntArray): this() {
            buf = filledBuf
            pos = filledBuf.size
        }

        override fun ensureCapacity(requiredCapacity: Int) {
            if (buf.size < requiredCapacity)
                buf = buf.copyOf(requiredCapacity.coerceAtLeast(buf.size * 2))
        }

        internal fun append(c: Int) {
            ensureCapacity()
            buf[pos++] = c
        }

        override fun build() = buf.copyOf(pos)
    }

    override fun IntArray.objSize(): Int = size
    override fun builder(): Builder = Builder()
    override fun IntArray.toBuilder(): Builder = Builder(this)

    override fun readItem(decoder: CompositeDecoder, index: Int, builder: Builder, checkIndex: Boolean) {
        builder.append(decoder.decodeIntElement(descriptor, index))
    }

    override fun writeContents(encoder: CompositeEncoder, content: IntArray, size: Int) {
        for (i in 0 until size)
            encoder.encodeIntElement(descriptor, i, content[i])
    }
}

class LongArraySerializer() :
    PrimitiveArraySerializer<Long, LongArray, LongArraySerializer.Builder>(LongSerializer, LongDescriptor),
    KSerializer<LongArray> {
    inner class Builder internal constructor() :
        PrimitiveArraySerializer<Long, LongArray, LongArraySerializer.Builder>.Builder() {

        private var buf: LongArray = LongArray(INITIAL_SIZE)
        override var pos: Int = 0
            private set

        constructor(filledBuf: LongArray): this() {
            buf = filledBuf
            pos = filledBuf.size
        }

        override fun ensureCapacity(requiredCapacity: Int) {
            if (buf.size < requiredCapacity)
                buf = buf.copyOf(requiredCapacity.coerceAtLeast(buf.size * 2))
        }

        internal fun append(c: Long) {
            ensureCapacity()
            buf[pos++] = c
        }

        override fun build() = buf.copyOf(pos)
    }

    override fun LongArray.objSize(): Int = size
    override fun builder(): Builder = Builder()
    override fun LongArray.toBuilder(): Builder = Builder(this)

    override fun readItem(decoder: CompositeDecoder, index: Int, builder: Builder, checkIndex: Boolean) {
        builder.append(decoder.decodeLongElement(descriptor, index))
    }

    override fun writeContents(encoder: CompositeEncoder, content: LongArray, size: Int) {
        for (i in 0 until size)
            encoder.encodeLongElement(descriptor, i, content[i])
    }
}

class FloatArraySerializer() :
    PrimitiveArraySerializer<Float, FloatArray, FloatArraySerializer.Builder>(FloatSerializer, FloatDescriptor),
    KSerializer<FloatArray> {
    inner class Builder internal constructor() :
        PrimitiveArraySerializer<Float, FloatArray, FloatArraySerializer.Builder>.Builder() {

        private var buf: FloatArray = FloatArray(INITIAL_SIZE)
        override var pos: Int = 0
            private set

        constructor(filledBuf: FloatArray): this() {
            buf = filledBuf
            pos = filledBuf.size
        }

        override fun ensureCapacity(requiredCapacity: Int) {
            if (buf.size < requiredCapacity)
                buf = buf.copyOf(requiredCapacity.coerceAtLeast(buf.size * 2))
        }

        internal fun append(c: Float) {
            ensureCapacity()
            buf[pos++] = c
        }

        override fun build() = buf.copyOf(pos)
    }

    override fun FloatArray.objSize(): Int = size
    override fun builder(): Builder = Builder()
    override fun FloatArray.toBuilder(): Builder = Builder(this)

    override fun readItem(decoder: CompositeDecoder, index: Int, builder: Builder, checkIndex: Boolean) {
        builder.append(decoder.decodeFloatElement(descriptor, index))
    }

    override fun writeContents(encoder: CompositeEncoder, content: FloatArray, size: Int) {
        for (i in 0 until size)
            encoder.encodeFloatElement(descriptor, i, content[i])
    }
}

class DoubleArraySerializer() :
    PrimitiveArraySerializer<Double, DoubleArray, DoubleArraySerializer.Builder>(DoubleSerializer, DoubleDescriptor),
    KSerializer<DoubleArray> {
    inner class Builder internal constructor() :
        PrimitiveArraySerializer<Double, DoubleArray, DoubleArraySerializer.Builder>.Builder() {

        private var buf: DoubleArray = DoubleArray(INITIAL_SIZE)
        override var pos: Int = 0
            private set

        constructor(filledBuf: DoubleArray): this() {
            buf = filledBuf
            pos = filledBuf.size
        }

        override fun ensureCapacity(requiredCapacity: Int) {
            if (buf.size < requiredCapacity)
                buf = buf.copyOf(requiredCapacity.coerceAtLeast(buf.size * 2))
        }

        internal fun append(c: Double) {
            ensureCapacity()
            buf[pos++] = c
        }

        override fun build() = buf.copyOf(pos)
    }

    override fun DoubleArray.objSize(): Int = size
    override fun builder(): Builder = Builder()
    override fun DoubleArray.toBuilder(): Builder = Builder(this)

    override fun readItem(decoder: CompositeDecoder, index: Int, builder: Builder, checkIndex: Boolean) {
        builder.append(decoder.decodeDoubleElement(descriptor, index))
    }

    override fun writeContents(encoder: CompositeEncoder, content: DoubleArray, size: Int) {
        for (i in 0 until size)
            encoder.encodeDoubleElement(descriptor, i, content[i])
    }
}

class CharArraySerializer() :
    PrimitiveArraySerializer<Char, CharArray, CharArraySerializer.Builder>(CharSerializer, CharDescriptor),
    KSerializer<CharArray> {
    inner class Builder internal constructor() :
        PrimitiveArraySerializer<Char, CharArray, CharArraySerializer.Builder>.Builder() {

        private var buf: CharArray = CharArray(INITIAL_SIZE)
        override var pos: Int = 0
            private set

        constructor(filledBuf: CharArray): this() {
            buf = filledBuf
            pos = filledBuf.size
        }

        override fun ensureCapacity(requiredCapacity: Int) {
            if (buf.size < requiredCapacity)
                buf = buf.copyOf(requiredCapacity.coerceAtLeast(buf.size * 2))
        }

        internal fun append(c: Char) {
            ensureCapacity()
            buf[pos++] = c
        }

        override fun build() = buf.copyOf(pos)
    }

    override fun CharArray.objSize(): Int = size
    override fun builder(): Builder = Builder()
    override fun CharArray.toBuilder(): Builder = Builder(this)

    override fun readItem(decoder: CompositeDecoder, index: Int, builder: Builder, checkIndex: Boolean) {
        builder.append(decoder.decodeCharElement(descriptor, index))
    }

    override fun writeContents(encoder: CompositeEncoder, content: CharArray, size: Int) {
        for (i in 0 until size)
            encoder.encodeCharElement(descriptor, i, content[i])
    }
}

class BooleanArraySerializer() :
    PrimitiveArraySerializer<Boolean, BooleanArray, BooleanArraySerializer.Builder>(BooleanSerializer, BooleanDescriptor),
    KSerializer<BooleanArray> {
    inner class Builder internal constructor() :
        PrimitiveArraySerializer<Boolean, BooleanArray, BooleanArraySerializer.Builder>.Builder() {

        private var buf: BooleanArray = BooleanArray(INITIAL_SIZE)
        override var pos: Int = 0
            private set

        constructor(filledBuf: BooleanArray): this() {
            buf = filledBuf
            pos = filledBuf.size
        }

        override fun ensureCapacity(requiredCapacity: Int) {
            if (buf.size < requiredCapacity)
                buf = buf.copyOf(requiredCapacity.coerceAtLeast(buf.size * 2))
        }

        internal fun append(c: Boolean) {
            ensureCapacity()
            buf[pos++] = c
        }

        override fun build() = buf.copyOf(pos)
    }

    override fun BooleanArray.objSize(): Int = size
    override fun builder(): Builder = Builder()
    override fun BooleanArray.toBuilder(): Builder = Builder(this)

    override fun readItem(decoder: CompositeDecoder, index: Int, builder: Builder, checkIndex: Boolean) {
        builder.append(decoder.decodeBooleanElement(descriptor, index))
    }

    override fun writeContents(encoder: CompositeEncoder, content: BooleanArray, size: Int) {
        for (i in 0 until size)
            encoder.encodeBooleanElement(descriptor, i, content[i])
    }
}
