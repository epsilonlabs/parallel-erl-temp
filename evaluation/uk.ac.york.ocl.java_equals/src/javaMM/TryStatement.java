/**
 */
package javaMM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Try Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link javaMM.TryStatement#getBody <em>Body</em>}</li>
 *   <li>{@link javaMM.TryStatement#getFinally <em>Finally</em>}</li>
 *   <li>{@link javaMM.TryStatement#getCatchClauses <em>Catch Clauses</em>}</li>
 * </ul>
 *
 * @see javaMM.JavaMMPackage#getTryStatement()
 * @model
 * @generated
 */
public interface TryStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see javaMM.JavaMMPackage#getTryStatement_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link javaMM.TryStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

	/**
	 * Returns the value of the '<em><b>Finally</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally</em>' containment reference.
	 * @see #setFinally(Block)
	 * @see javaMM.JavaMMPackage#getTryStatement_Finally()
	 * @model containment="true"
	 * @generated
	 */
	Block getFinally();

	/**
	 * Sets the value of the '{@link javaMM.TryStatement#getFinally <em>Finally</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally</em>' containment reference.
	 * @see #getFinally()
	 * @generated
	 */
	void setFinally(Block value);

	/**
	 * Returns the value of the '<em><b>Catch Clauses</b></em>' containment reference list.
	 * The list contents are of type {@link javaMM.CatchClause}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch Clauses</em>' containment reference list.
	 * @see javaMM.JavaMMPackage#getTryStatement_CatchClauses()
	 * @model containment="true"
	 * @generated
	 */
	EList<CatchClause> getCatchClauses();

} // TryStatement
