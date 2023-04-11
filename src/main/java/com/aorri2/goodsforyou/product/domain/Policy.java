package com.aorri2.goodsforyou.product.domain;

public interface Policy<T> {

	void apply(T t);
}
