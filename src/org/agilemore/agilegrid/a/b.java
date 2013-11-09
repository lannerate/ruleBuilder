package org.agilemore.agilegrid.a;

import org.agilemore.agilegrid.au;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public class b extends g
{
  private static final int n = 16;
  private static final int o = 6;
  private Composite p;
  private Label q;
  private Label r;
  private Image s;

  public b(e parame)
  {
    this(parame, 0);
  }

  public b(e parame, int paramInt)
  {
    super(parame, paramInt);
    a(new RGB(0, 0, 0));
  }

  private ImageData a(Control paramControl, RGB paramRGB)
  {
    GC localGC = new GC(paramControl);
    FontMetrics localFontMetrics = localGC.getFontMetrics();
    int i = localFontMetrics.getAscent();
    localGC.dispose();
    int j = 6;
    int k = 16;
    if ((paramControl instanceof e))
      k = ((e)paramControl).w().e(0) - 1;
    if (i > k)
      i = k;
    int m = j + i;
    int i1 = k;
    int i2 = j;
    int i3 = (i1 - i) / 2;
    RGB localRGB = new RGB(0, 0, 0);
    PaletteData localPaletteData = new PaletteData(new RGB[] { localRGB, localRGB, paramRGB });
    ImageData localImageData = new ImageData(m, i1, 4, localPaletteData);
    localImageData.transparentPixel = 0;
    int i4 = i - 1;
    for (int i5 = 0; i5 < i; i5++)
      for (int i6 = 0; i6 < i; i6++)
        if ((i6 == 0) || (i5 == 0) || (i6 == i4) || (i5 == i4))
          localImageData.setPixel(i6 + i2, i5 + i3, 1);
        else
          localImageData.setPixel(i6 + i2, i5 + i3, 2);
    return localImageData;
  }

  protected Control a(Composite paramComposite)
  {
    Color localColor = paramComposite.getBackground();
    this.p = new Composite(paramComposite, h());
    this.p.setBackground(localColor);
    this.p.setLayout(new c(this, null));
    this.q = new Label(this.p, 16384);
    this.q.setBackground(localColor);
    this.r = new Label(this.p, 16384);
    this.r.setBackground(localColor);
    this.r.setFont(paramComposite.getFont());
    return this.p;
  }

  public void c()
  {
    if (this.s != null)
    {
      this.s.dispose();
      this.s = null;
    }
    super.c();
  }

  protected Object a(Control paramControl)
  {
    ColorDialog localColorDialog = new ColorDialog(paramControl.getShell());
    Object localObject = m();
    if (localObject != null)
      localColorDialog.setRGB((RGB)localObject);
    localObject = localColorDialog.open();
    return localColorDialog.getRGB();
  }

  protected void d(Object paramObject)
  {
    RGB localRGB = (RGB)paramObject;
    if (localRGB == null)
      localRGB = new RGB(0, 0, 0);
    if (this.s != null)
      this.s.dispose();
    ImageData localImageData1 = a(this.q.getParent().getParent(), localRGB);
    ImageData localImageData2 = localImageData1.getTransparencyMask();
    this.s = new Image(this.q.getDisplay(), localImageData1, localImageData2);
    this.q.setImage(this.s);
    this.r.setText("(" + localRGB.red + "," + localRGB.green + "," + localRGB.blue + ")");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.b
 * JD-Core Version:    0.6.0
 */