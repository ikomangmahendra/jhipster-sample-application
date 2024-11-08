package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertConsumerAllPropertiesEquals(Consumer expected, Consumer actual) {
        assertConsumerAutoGeneratedPropertiesEquals(expected, actual);
        assertConsumerAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertConsumerAllUpdatablePropertiesEquals(Consumer expected, Consumer actual) {
        assertConsumerUpdatableFieldsEquals(expected, actual);
        assertConsumerUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertConsumerAutoGeneratedPropertiesEquals(Consumer expected, Consumer actual) {
        assertThat(expected)
            .as("Verify Consumer auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertConsumerUpdatableFieldsEquals(Consumer expected, Consumer actual) {
        assertThat(expected)
            .as("Verify Consumer relevant properties")
            .satisfies(e -> assertThat(e.getGuid()).as("check guid").isEqualTo(actual.getGuid()))
            .satisfies(e -> assertThat(e.getNote()).as("check note").isEqualTo(actual.getNote()))
            .satisfies(e -> assertThat(e.getCreatedBy()).as("check createdBy").isEqualTo(actual.getCreatedBy()))
            .satisfies(e -> assertThat(e.getCreatedDate()).as("check createdDate").isEqualTo(actual.getCreatedDate()))
            .satisfies(e -> assertThat(e.getLastModifiedBy()).as("check lastModifiedBy").isEqualTo(actual.getLastModifiedBy()))
            .satisfies(e -> assertThat(e.getLastModifiedDate()).as("check lastModifiedDate").isEqualTo(actual.getLastModifiedDate()))
            .satisfies(e -> assertThat(e.getRecordStatusId()).as("check recordStatusId").isEqualTo(actual.getRecordStatusId()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertConsumerUpdatableRelationshipsEquals(Consumer expected, Consumer actual) {
        // empty method
    }
}