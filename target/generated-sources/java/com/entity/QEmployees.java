package com.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployees is a Querydsl query type for Employees
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmployees extends EntityPathBase<Employees> {

    private static final long serialVersionUID = -1902085145L;

    public static final QEmployees employees = new QEmployees("employees");

    public final QAuditable _super = new QAuditable(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath last_modified_by = _super.last_modified_by;

    //inherited
    public final DateTimePath<java.util.Date> last_modified_date = _super.last_modified_date;

    public final StringPath lastName = createString("lastName");

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final SetPath<Roles, QRoles> roles = this.<Roles, QRoles>createSet("roles", Roles.class, QRoles.class, PathInits.DIRECT2);

    public QEmployees(String variable) {
        super(Employees.class, forVariable(variable));
    }

    public QEmployees(Path<? extends Employees> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployees(PathMetadata metadata) {
        super(Employees.class, metadata);
    }

}

