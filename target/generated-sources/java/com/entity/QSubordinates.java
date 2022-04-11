package com.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubordinates is a Querydsl query type for Subordinates
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubordinates extends EntityPathBase<Subordinates> {

    private static final long serialVersionUID = 23385861L;

    public static final QSubordinates subordinates = new QSubordinates("subordinates");

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

    public final NumberPath<Integer> supervisorId = createNumber("supervisorId", Integer.class);

    public final StringPath team = createString("team");

    public QSubordinates(String variable) {
        super(Subordinates.class, forVariable(variable));
    }

    public QSubordinates(Path<? extends Subordinates> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubordinates(PathMetadata metadata) {
        super(Subordinates.class, metadata);
    }

}

