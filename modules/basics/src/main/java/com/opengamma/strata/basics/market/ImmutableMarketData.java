/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.basics.market;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableMap;
import com.opengamma.strata.collect.timeseries.LocalDateDoubleTimeSeries;

/**
 * Immutable bean implementation of {@link MarketData}.
 */
@BeanDefinition
public final class ImmutableMarketData implements MarketData, ImmutableBean {

  /** The market data values. */
  @PropertyDefinition(validate = "notNull", builderType = "Map<? extends MarketDataKey<?>, ?>")
  private final Map<MarketDataKey<?>, Object> values;

  /** The time series. */
  @PropertyDefinition(validate = "notNull")
  private final Map<ObservableKey, LocalDateDoubleTimeSeries> timeSeries;

  @Override
  public boolean containsValue(MarketDataKey<?> key) {
    return values.containsKey(key);
  }

  @Override
  public boolean containsTimeSeries(ObservableKey key) {
    return timeSeries.containsKey(key);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getValue(MarketDataKey<T> key) {
    Object value = values.get(key);

    if (value == null) {
      throw new IllegalArgumentException("No market data available for key " + key);
    }
    return (T) value;
  }

  @Override
  public LocalDateDoubleTimeSeries getTimeSeries(ObservableKey key) {
    LocalDateDoubleTimeSeries timeSeries = this.timeSeries.get(key);

    if (timeSeries == null) {
      throw new IllegalArgumentException("No time series data available for key " + key);
    }
    return timeSeries;
  }
  
  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ImmutableMarketData}.
   * @return the meta-bean, not null
   */
  public static ImmutableMarketData.Meta meta() {
    return ImmutableMarketData.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ImmutableMarketData.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ImmutableMarketData.Builder builder() {
    return new ImmutableMarketData.Builder();
  }

  private ImmutableMarketData(
      Map<? extends MarketDataKey<?>, ?> values,
      Map<ObservableKey, LocalDateDoubleTimeSeries> timeSeries) {
    JodaBeanUtils.notNull(values, "values");
    JodaBeanUtils.notNull(timeSeries, "timeSeries");
    this.values = ImmutableMap.copyOf(values);
    this.timeSeries = ImmutableMap.copyOf(timeSeries);
  }

  @Override
  public ImmutableMarketData.Meta metaBean() {
    return ImmutableMarketData.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the market data values.
   * @return the value of the property, not null
   */
  public Map<MarketDataKey<?>, Object> getValues() {
    return values;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the time series.
   * @return the value of the property, not null
   */
  public Map<ObservableKey, LocalDateDoubleTimeSeries> getTimeSeries() {
    return timeSeries;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ImmutableMarketData other = (ImmutableMarketData) obj;
      return JodaBeanUtils.equal(values, other.values) &&
          JodaBeanUtils.equal(timeSeries, other.timeSeries);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(values);
    hash = hash * 31 + JodaBeanUtils.hashCode(timeSeries);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("ImmutableMarketData{");
    buf.append("values").append('=').append(values).append(',').append(' ');
    buf.append("timeSeries").append('=').append(JodaBeanUtils.toString(timeSeries));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ImmutableMarketData}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code values} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<Map<MarketDataKey<?>, Object>> values = DirectMetaProperty.ofImmutable(
        this, "values", ImmutableMarketData.class, (Class) Map.class);
    /**
     * The meta-property for the {@code timeSeries} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<Map<ObservableKey, LocalDateDoubleTimeSeries>> timeSeries = DirectMetaProperty.ofImmutable(
        this, "timeSeries", ImmutableMarketData.class, (Class) Map.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "values",
        "timeSeries");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -823812830:  // values
          return values;
        case 779431844:  // timeSeries
          return timeSeries;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ImmutableMarketData.Builder builder() {
      return new ImmutableMarketData.Builder();
    }

    @Override
    public Class<? extends ImmutableMarketData> beanType() {
      return ImmutableMarketData.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code values} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Map<MarketDataKey<?>, Object>> values() {
      return values;
    }

    /**
     * The meta-property for the {@code timeSeries} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Map<ObservableKey, LocalDateDoubleTimeSeries>> timeSeries() {
      return timeSeries;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -823812830:  // values
          return ((ImmutableMarketData) bean).getValues();
        case 779431844:  // timeSeries
          return ((ImmutableMarketData) bean).getTimeSeries();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code ImmutableMarketData}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<ImmutableMarketData> {

    private Map<? extends MarketDataKey<?>, ?> values = ImmutableMap.of();
    private Map<ObservableKey, LocalDateDoubleTimeSeries> timeSeries = ImmutableMap.of();

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(ImmutableMarketData beanToCopy) {
      this.values = ImmutableMap.copyOf(beanToCopy.getValues());
      this.timeSeries = ImmutableMap.copyOf(beanToCopy.getTimeSeries());
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -823812830:  // values
          return values;
        case 779431844:  // timeSeries
          return timeSeries;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -823812830:  // values
          this.values = (Map<? extends MarketDataKey<?>, ?>) newValue;
          break;
        case 779431844:  // timeSeries
          this.timeSeries = (Map<ObservableKey, LocalDateDoubleTimeSeries>) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public ImmutableMarketData build() {
      return new ImmutableMarketData(
          values,
          timeSeries);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the market data values.
     * @param values  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder values(Map<? extends MarketDataKey<?>, ?> values) {
      JodaBeanUtils.notNull(values, "values");
      this.values = values;
      return this;
    }

    /**
     * Sets the time series.
     * @param timeSeries  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder timeSeries(Map<ObservableKey, LocalDateDoubleTimeSeries> timeSeries) {
      JodaBeanUtils.notNull(timeSeries, "timeSeries");
      this.timeSeries = timeSeries;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("ImmutableMarketData.Builder{");
      buf.append("values").append('=').append(JodaBeanUtils.toString(values)).append(',').append(' ');
      buf.append("timeSeries").append('=').append(JodaBeanUtils.toString(timeSeries));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
