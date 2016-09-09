package com.hmw.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exame.class)
public abstract class Exame_ {

	public static volatile ListAttribute<Exame, Imagem> imagens;
	public static volatile SingularAttribute<Exame, Usuario> requisitante;
	public static volatile SingularAttribute<Exame, Integer> id;
	public static volatile SingularAttribute<Exame, String> descricao;

}

