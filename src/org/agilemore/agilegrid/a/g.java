package org.agilemore.agilegrid.a;

import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public abstract class g extends J
{
  public static final String a = "cell_editor_dots_button_image";
  private Composite n;
  private Control o;
  private Label p;
  private Button q;
  private FocusListener r = new h(this);
  private Object s = null;
  private static final int t = 0;

  public g(e parame)
  {
    this(parame, 0);
  }

  public g(e parame, int paramInt)
  {
    super(parame, paramInt);
  }

  protected Button b(Composite paramComposite)
  {
    Button localButton = new Button(paramComposite, 1028);
    return localButton;
  }

  protected Control a(Composite paramComposite)
  {
    this.p = new Label(paramComposite, 8404992);
    this.p.setFont(paramComposite.getFont());
    this.p.setBackground(paramComposite.getBackground());
    return this.p;
  }

  protected Control a(e parame)
  {
    Font localFont = parame.getFont();
    Color localColor = parame.getBackground();
    this.n = new Composite(parame, h());
    this.n.setFont(localFont);
    this.n.setBackground(localColor);
    this.n.setLayout(new k(this, null));
    this.o = a(this.n);
    d(this.s);
    this.q = b(this.n);
    this.q.setFont(localFont);
    this.q.addKeyListener(new i(this));
    this.q.addSelectionListener(new j(this));
    a(true);
    return this.n;
  }

  public void b()
  {
    if ((this.q != null) && (!this.q.isDisposed()))
      this.q.removeFocusListener(this.r);
    super.b();
  }

  protected Object d()
  {
    return this.s;
  }

  protected void e()
  {
    this.q.addFocusListener(this.r);
    this.q.setFocus();
  }

  protected void a(Object paramObject)
  {
    this.s = paramObject;
    d(paramObject);
  }

  protected Label M()
  {
    return this.p;
  }

  protected abstract Object a(Control paramControl);

  protected void d(Object paramObject)
  {
    if (this.p == null)
      return;
    String str = "";
    if (paramObject != null)
      str = paramObject.toString();
    this.p.setText(str);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.g
 * JD-Core Version:    0.6.0
 */