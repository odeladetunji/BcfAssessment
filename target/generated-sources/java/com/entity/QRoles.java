package com.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoles is a Querydsl query type for Roles
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoles extends EntityPathBase<Roles> {

    private static final long serialVersionUID = 592092191L;

    public static final QRoles roles = new QRoles("roles");

    public final QAuditable _super = new QAuditable(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath last_modified_by = _super.last_modified_by;

    //inherited
    public final DateTimePath<java.util.Date> last_modified_date = _super.last_modified_date;

    public final EnumPath<Eroles> name = createEnum("name", Eroles.class);

    public QRoles(String variable) {
        super(Roles.class, forVariable(variable));
    }

    public QRoles(Path<? extends Roles> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoles(PathMetadata metadata) {
        super(Roles.class, metadata);
    }

}

