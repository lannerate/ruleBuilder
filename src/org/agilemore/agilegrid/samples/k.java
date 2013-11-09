package org.agilemore.agilegrid.samples;

import com.a.c;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class k extends org.agilemore.agilegrid.a.l
{
  private Object a;
  private CLabel o;
  private ToolItem p;
  private ToolItem q;
  private Label r;

  public k(e parame)
  {
    this(parame, null);
  }

  public k(e parame, Object paramObject)
  {
    this(parame, 0, paramObject);
  }

  public k(e parame, int paramInt, Object paramObject)
  {
    super(parame, paramInt);
    this.a = paramObject;
  }

  protected Control a(Composite paramComposite)
  {
    Display localDisplay = paramComposite.getDisplay();
    Composite localComposite1 = new Composite(paramComposite, 0);
    localComposite1.setBackground(localDisplay.getSystemColor(1));
    GridLayout localGridLayout1 = new GridLayout();
    localGridLayout1.marginHeight = 0;
    localGridLayout1.marginWidth = 0;
    localComposite1.setLayoutData(new GridData(4, 4, true, true));
    localComposite1.setLayout(localGridLayout1);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setBackground(localDisplay.getSystemColor(1));
    localComposite2.setLayoutData(new GridData(4, 16777216, false, false));
    GridLayout localGridLayout2 = new GridLayout();
    localGridLayout2.marginWidth = 0;
    localGridLayout2.marginHeight = 0;
    localGridLayout2.numColumns = 1;
    localComposite2.setLayout(localGridLayout2);
    Composite localComposite3 = new Composite(localComposite2, 0);
    localComposite3.setBackground(localDisplay.getSystemColor(1));
    localComposite3.setLayoutData(new GridData(4, 16777216, true, false));
    GridLayout localGridLayout3 = new GridLayout();
    localGridLayout3.marginHeight = 0;
    localGridLayout3.numColumns = 2;
    localComposite3.setLayout(localGridLayout3);
    CLabel localCLabel = new CLabel(localComposite3, 0);
    localCLabel.setBackground(localDisplay.getSystemColor(1));
    localCLabel.setImage(c.b(k.class, "/icons/mail_earth.png"));
    this.r = new Label(localComposite3, 0);
    this.r.setBackground(localDisplay.getSystemColor(1));
    this.r.setLayoutData(new GridData(4, 16777216, true, false));
    Object localObject = m();
    int i = 0;
    if ((this.a != null) && ((this.a instanceof Integer)))
      i = ((Integer)this.a).intValue();
    if (i == 0)
      this.r.setText("Send Mail: " + localObject.toString());
    else if (i == 1)
      this.r.setText("Write Mail: " + localObject.toString());
    Label localLabel = new Label(localComposite1, 258);
    localLabel.setLayoutData(new GridData(4, 16777216, false, false));
    localLabel.setAlignment(16777216);
    Composite localComposite4 = new Composite(localComposite1, 0);
    localComposite4.setLayoutData(new GridData(4, 4, true, true));
    localComposite4.setBackground(localComposite1.getBackground());
    GridLayout localGridLayout4 = new GridLayout();
    localGridLayout4.marginWidth = 0;
    localGridLayout4.marginHeight = 0;
    localGridLayout4.numColumns = 1;
    localComposite4.setLayout(localGridLayout4);
    c(localComposite4);
    return localComposite1;
  }

  protected void c(Composite paramComposite)
  {
    this.o = new CLabel(paramComposite, 0);
    this.o.setLayoutData(new GridData(16777216, 16777216, true, true));
    this.o.setBackground(paramComposite.getBackground());
    int i = 0;
    if ((this.a != null) && ((this.a instanceof Integer)))
      i = ((Integer)this.a).intValue();
    if (i == 0)
      this.o.setImage(c.b(k.class, "/icons/browser.png"));
    else if (i == 1)
      this.o.setImage(c.b(k.class, "/icons/email.png"));
  }

  protected void b(Composite paramComposite)
  {
    CoolBar localCoolBar = new CoolBar(paramComposite, 0);
    localCoolBar.setLayoutData(new GridData(4, 16777216, true, false));
    CoolItem localCoolItem = new CoolItem(localCoolBar, 8);
    int i = 0;
    if ((this.a != null) && ((this.a instanceof Integer)))
      i = ((Integer)this.a).intValue();
    ToolBar localToolBar = a(localCoolBar, i);
    localCoolItem.setControl(localToolBar);
    c.a(localCoolBar);
    localCoolBar.setLocked(true);
  }

  public ToolBar a(Composite paramComposite, int paramInt)
  {
    ToolBar localToolBar = new ToolBar(paramComposite, 0);
    this.p = new ToolItem(localToolBar, 8);
    this.p.addSelectionListener(new l(this));
    this.p.setToolTipText("Send Mail");
    this.p.setImage(c.b(k.class, "/icons/send_mail.png"));
    if (paramInt == 0)
      this.p.setEnabled(false);
    this.q = new ToolItem(localToolBar, 8);
    this.q.addSelectionListener(new m(this));
    this.q.setToolTipText("Write Mail");
    this.q.setImage(c.b(k.class, "/icons/write_mail.png"));
    if (paramInt == 1)
      this.q.setEnabled(false);
    return localToolBar;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.k
 * JD-Core Version:    0.6.0
 */