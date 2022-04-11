package com.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSupervisors is a Querydsl query type for Supervisors
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSupervisors extends EntityPathBase<Supervisors> {

    private static final long serialVersionUID = -236382739L;

    public static final QSupervisors supervisors = new QSupervisors("supervisors");

    public final QAuditable _super = new QAuditable(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final NumberPath<Integer> employeeId = createNumber("employeeId", Integer.class);

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath last_modified_by = _super.last_modified_by;

    //inherited
    public final DateTimePath<java.util.Date> last_modified_date = _super.last_modified_date;

    public final StringPath lastName = createString("lastName");

    public final StringPath team = createString("team");

    public QSupervisors(String variable) {
        super(Supervisors.class, forVariable(variable));
    }

    public QSupervisors(Path<? extends Supervisors> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSupervisors(PathMetadata metadata) {
        super(Supervisors.class, metadata);
    }

}

