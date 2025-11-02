# 🎨 Picnic UI/UX Guidelines

This document outlines the user interface and user experience design principles for Picnic, ensuring a consistent, modern, and delightful experience across all platforms.

**Version**: 1.0  
**Last Updated**: November 2025

---

## 🌈 Design Philosophy

Picnic's design embodies three core principles:

1. **Vibrant & Playful** - Energetic colors and dynamic layouts that feel alive
2. **Clean & Minimal** - Uncluttered interfaces that let content shine
3. **Smooth & Intuitive** - Fluid animations and predictable interactions

---

## 🎨 Color System

### Primary Colors

```
Primary Yellow:    #F4FF6C (244, 255, 108)
Primary Green:     #7CFF6C (124, 255, 108)
Primary Gradient:  linear-gradient(135deg, #F4FF6C 0%, #7CFF6C 100%)
```

### Neutral Colors

```
Background Dark:   #000000 (0, 0, 0)
Surface Dark:      #1A1A1A (26, 26, 26)
Surface Light:     #2D2D2D (45, 45, 45)
Border:           #3D3D3D (61, 61, 61)
```

### Text Colors

```
Text Primary:      #FFFFFF (255, 255, 255)
Text Secondary:    #B3B3B3 (179, 179, 179)
Text Tertiary:     #808080 (128, 128, 128)
Text Disabled:     #4D4D4D (77, 77, 77)
```

### Accent Colors

```
Accent Pink:       #FF6BCF (255, 107, 207)
Accent Blue:       #6B9FFF (107, 159, 255)
Accent Orange:     #FFB56B (255, 181, 107)
Live Red:          #FF4444 (255, 68, 68)
```

### Semantic Colors

```
Success:           #4ADE80 (74, 222, 128)
Warning:           #FBBF24 (251, 191, 36)
Error:             #F87171 (248, 113, 113)
Info:              #60A5FA (96, 165, 250)
```

### Color Usage

- **Primary Gradient**: Buttons, CTAs, branding, follow buttons, highlights
- **Background Dark**: App background, behind content
- **Surface Dark**: Cards, modals, bottom sheets
- **Accent Colors**: Icons, badges, reactions, special UI elements
- **Live Red**: Live streaming indicators, urgent notifications

---

## ✍️ Typography

### Font Families

**Primary Font**: System Default
- iOS: SF Pro
- Android: Roboto
- Desktop: System Font
- Web: -apple-system, BlinkMacSystemFont, "Segoe UI"

**Display Font**: Rounded/Bold variant for headings and branding

### Font Scales

```
Heading XL:   32px / 2rem    (Bold, Line height: 40px)
Heading L:    24px / 1.5rem  (Bold, Line height: 32px)
Heading M:    20px / 1.25rem (Semi-bold, Line height: 28px)
Heading S:    18px / 1.125rem (Semi-bold, Line height: 24px)

Body L:       16px / 1rem    (Regular, Line height: 24px)
Body M:       14px / 0.875rem (Regular, Line height: 20px)
Body S:       12px / 0.75rem (Regular, Line height: 16px)

Caption:      11px / 0.6875rem (Regular, Line height: 14px)
Overline:     10px / 0.625rem (Bold, Uppercase, Line height: 12px)
```

### Font Weights

```
Regular:      400
Medium:       500
Semi-bold:    600
Bold:         700
Extra-bold:   800
```

---

## 📐 Spacing System

Based on 4px grid system:

```
XXS:  4px   (0.25rem)
XS:   8px   (0.5rem)
S:    12px  (0.75rem)
M:    16px  (1rem)
L:    24px  (1.5rem)
XL:   32px  (2rem)
XXL:  48px  (3rem)
XXXL: 64px  (4rem)
```

### Common Spacing Patterns

- **Screen Padding**: 16px (M)
- **Card Padding**: 16px (M)
- **Element Gap**: 12px (S)
- **Section Gap**: 24px (L)
- **Component Margin**: 8px (XS)

---

## 🔲 Components

### Buttons

#### Primary Button
```
Background: Primary Gradient
Text: #000000 (Black)
Font: Body L (16px), Bold
Padding: 16px 32px
Border Radius: 24px (Pill-shaped)
Height: 56px
Shadow: 0 4px 12px rgba(244, 255, 108, 0.3)
```

**States**:
- Hover: Scale 1.02, increased shadow
- Pressed: Scale 0.98
- Disabled: Opacity 0.4, no interaction

#### Secondary Button
```
Background: Transparent
Border: 2px solid #3D3D3D
Text: #FFFFFF
Font: Body L (16px), Semi-bold
Padding: 14px 30px
Border Radius: 24px
Height: 56px
```

#### Icon Button
```
Size: 44x44px (minimum touch target)
Background: #2D2D2D
Border Radius: 22px (circle)
Icon Size: 24x24px
```

### Input Fields

#### Text Input
```
Background: #2D2D2D
Border: 1px solid #3D3D3D
Border Radius: 12px
Padding: 16px
Font: Body L (16px)
Height: 52px
```

**States**:
- Focus: Border color changes to Primary Gradient
- Error: Border color #F87171
- Success: Border color #4ADE80

#### Search Bar
```
Background: #2D2D2D
Border Radius: 24px (Pill)
Padding: 12px 16px
Height: 44px
Icon: Magnifying glass (left)
Clear button: X icon (right, appears when typing)
```

### Cards

#### Post Card
```
Background: #1A1A1A
Border Radius: 16px
Padding: 16px
Margin Bottom: 12px
Shadow: 0 2px 8px rgba(0, 0, 0, 0.2)
```

**Structure**:
- Header: Avatar (40px) + Name + Timestamp + Menu (3 dots)
- Content: Image/Video + Caption
- Actions: Like, Comment, Share, Bookmark icons
- Footer: Like count + Comment count

#### User Card
```
Background: #1A1A1A
Border Radius: 12px
Padding: 12px
Display: Flex (horizontal)
```

**Structure**:
- Avatar: 48px circle
- Info: Name + Username + Bio snippet
- Action: Follow button

#### Basket Card
```
Background: #1A1A1A
Border Radius: 16px
Aspect Ratio: 1:1 (square)
Padding: 0
```

**Structure**:
- Thumbnail: Grid of 4 images
- Overlay: Basket name + member count
- Action: Join/View button

### Navigation

#### Bottom Navigation Bar
```
Height: 64px
Background: #000000 with blur
Border Top: 1px solid #2D2D2D
```

**Items** (5 max):
- Icon size: 28x28px
- Active: Primary Gradient color
- Inactive: #808080
- Label: Body S (12px), below icon

**Tabs**:
1. Feed (Grid icon)
2. Explore (Compass icon)
3. Create (+ in gradient circle, elevated)
4. Clips (Play icon)
5. Profile (Avatar icon)

#### Top App Bar
```
Height: 56px
Background: #000000 with blur
Border Bottom: 1px solid #2D2D2D
Padding: 0 16px
```

**Structure**:
- Left: Logo or Back button
- Center: Title (optional)
- Right: Notifications + Messages icons

### Avatars

```
XS:  32x32px
S:   40x40px
M:   48x48px
L:   64x64px
XL:  96x96px
XXL: 128x128px
```

**Properties**:
- Border Radius: 50% (circle)
- Border: 2px solid (for stories: Primary Gradient)
- Fallback: Initials on gradient background

### Story Rings

```
Avatar Size: 64x64px
Ring Thickness: 3px
Ring Color: Primary Gradient (unviewed)
Ring Color: #3D3D3D (viewed)
Spacing: 8px between stories
```

### Badges

#### Notification Badge
```
Size: 20x20px (min)
Background: #FF4444
Text: White, Body S (12px), Bold
Border Radius: 10px (pill)
Position: Top-right of icon
```

#### Verified Badge
```
Icon: Checkmark in circle
Size: 16x16px
Color: #60A5FA (blue)
Position: Next to username
```

---

## 🎭 Iconography

### Style
- **Line Weight**: 2px
- **Style**: Rounded corners
- **Size**: 24x24px (default)
- **Color**: #FFFFFF (default), Primary Gradient (active)

### Core Icons
- Home: Grid or House
- Explore: Compass
- Create: Plus in circle
- Clips: Play button
- Profile: User silhouette
- Messages: Chat bubble
- Notifications: Bell
- Search: Magnifying glass
- More: Three dots
- Like: Thumbs up
- Comment: Chat bubble
- Share: Arrow pointing up/right
- Bookmark: Bookmark/Flag

---

## 🎬 Animations & Transitions

### Timing Functions

```
Ease Out:     cubic-bezier(0.0, 0.0, 0.2, 1)    - For entrances
Ease In:      cubic-bezier(0.4, 0.0, 1, 1)      - For exits
Ease In Out:  cubic-bezier(0.4, 0.0, 0.2, 1)    - For state changes
Spring:       cubic-bezier(0.34, 1.56, 0.64, 1) - For playful bounces
```

### Duration

```
Instant:      0ms      - Color changes
Fast:         150ms    - Hover effects
Normal:       300ms    - Standard transitions
Slow:         500ms    - Large movements
Very Slow:    800ms    - Dramatic effects
```

### Common Animations

#### Button Press
```
Scale: 0.98
Duration: 150ms
Easing: Ease In Out
```

#### Like Animation
```
1. Scale up to 1.3 (100ms)
2. Scale down to 1.0 (200ms)
3. Add particle burst effect
Color: Shift to Primary Gradient
```

#### Modal/Bottom Sheet Entry
```
Transform: translateY(100%) to translateY(0)
Opacity: 0 to 1
Duration: 300ms
Easing: Ease Out
Backdrop: Fade in (200ms)
```

#### Page Transitions
```
Slide: translateX(-100%) to translateX(0)
Duration: 300ms
Easing: Ease In Out
```

#### Skeleton Loading
```
Background: Linear gradient shimmer
Animation: Infinite loop, 1.5s
Direction: Left to right
```

---

## 📱 Screen Layouts

### Onboarding Screen

```
Layout: Center-aligned, full-screen
Background: #000000

Components:
- Logo: Top-left (32px from edges)
- Skip button: Top-right (pill button)
- Hero illustration: Center (60% of screen)
- Pagination dots: Below illustration
- Heading: Body (center-aligned)
- Description: Below heading
- CTA Button: Near bottom (16px margin)
- Secondary action: Below CTA (text link)
```

### Feed Screen

```
Layout: Vertical scroll
Background: #000000

Components:
- Top Bar: Logo + Notifications + Messages
- Story Bar: Horizontal scroll of story rings
- Feed Toggle: "Home" / "For You" tabs
- Post Cards: Vertical list with 12px gaps
- Bottom Navigation: Fixed at bottom
```

### Profile Screen

```
Layout: Vertical scroll
Background: Gradient header → Dark content

Components:
- Header Image: 200px height (optional)
- Back Button: Top-left overlay
- Menu: Top-right overlay
- Avatar: 128px, overlapping header
- Follow Button: Right of avatar
- Message Button: Left of follow button
- Name: Heading L, below avatar
- Username: Body M, @handle
- Bio: Body M, 2-3 lines max
- Location: Body S with pin icon
- Stats Row: Posts, Followers, Following, Likes
- Tab Bar: Grid / Clips / Saved icons
- Content Grid: 3 columns, 4px gaps
```

### Create Post Screen

```
Layout: Full-screen modal
Background: #000000

Components:
- Close Button: Top-left (X icon)
- Post Button: Top-right (Primary Gradient)
- User Info: Avatar + Name
- Text Input: Multi-line, auto-expand
- Media Picker: Bottom toolbar
- Character Count: Bottom-right
- Visibility Toggle: Bottom-left
```

---

## 🎯 Interactive Elements

### Touch Targets
- Minimum: 44x44px
- Recommended: 48x48px
- Icon buttons: 44x44px
- Text links: 44px height minimum

### Haptic Feedback
- Light: UI element selection
- Medium: Success actions (like, follow)
- Heavy: Destructive actions (delete)
- Selection: Scrolling through items

### Loading States
- **Skeleton screens** for content loading
- **Shimmer effect** for placeholders
- **Spinner** for processing actions
- **Progress bar** for uploads

### Empty States
```
Icon: Large (64x64px), gray
Heading: "No [content] yet"
Description: Helpful message
CTA: Primary action button (optional)
```

---

## 🌙 Dark Mode (Default)

Picnic is **dark mode first**, with light mode as an option.

### Light Mode Adjustments (Optional)

```
Background Light:  #FFFFFF
Surface Light:     #F5F5F5
Border Light:      #E0E0E0
Text Primary:      #000000
Text Secondary:    #666666
```

---

## ♿ Accessibility

### Color Contrast
- Text on background: Minimum 4.5:1
- Large text: Minimum 3:1
- Interactive elements: Minimum 3:1

### Typography
- Minimum font size: 12px
- Support dynamic type scaling
- Max line length: 70 characters

### Interactive Elements
- Clear focus indicators
- Keyboard navigation support
- Screen reader labels for all buttons
- Descriptive alt text for images

### Motion
- Respect "Reduce Motion" system setting
- Provide alternatives to animations
- Avoid flashing content (seizure risk)

---

## 📐 Layout Grid

### Mobile (< 768px)
- Columns: 4
- Gutter: 16px
- Margin: 16px

### Tablet (768px - 1024px)
- Columns: 8
- Gutter: 24px
- Margin: 24px

### Desktop (> 1024px)
- Columns: 12
- Gutter: 24px
- Margin: Auto (max-width: 1200px)

---

## 🎨 Design Tokens

Tokens are the single source of truth for design decisions, used across platforms.

### Example Token Structure

```json
{
  "color": {
    "primary": {
      "yellow": "#F4FF6C",
      "green": "#7CFF6C"
    },
    "neutral": {
      "black": "#000000",
      "surface": "#1A1A1A",
      "border": "#3D3D3D"
    }
  },
  "spacing": {
    "xs": "8px",
    "s": "12px",
    "m": "16px",
    "l": "24px",
    "xl": "32px"
  },
  "typography": {
    "heading": {
      "xl": {
        "size": "32px",
        "lineHeight": "40px",
        "weight": "700"
      }
    }
  }
}
```

---

## 🎬 Micro-interactions

### Like Button
- Tap: Scale up + color to gradient + particle burst
- Unlike: Scale down + color to gray + fade out particles

### Follow Button
- Tap: Text changes "Follow" → "Following"
- Background: Gradient → Gray outline
- Show checkmark icon briefly

### Comment Input
- Focus: Expand vertically
- Typing: Show character count
- Submit: Button pulses

### Pull to Refresh
- Pull down: Show loading spinner
- Release: Spinner rotates, content refreshes
- Complete: Spinner fades out

### Image Loading
- Show: Blurred placeholder → Sharp image
- Transition: Fade in (300ms)

---

## 📸 Image Specifications

### Post Images
- Aspect Ratios: 1:1 (square), 4:5 (portrait), 16:9 (landscape)
- Max Resolution: 2048x2048px
- Format: JPEG, PNG, WebP
- Max File Size: 20MB

### Profile Pictures
- Aspect Ratio: 1:1 (square, auto-cropped to circle)
- Resolution: 512x512px
- Format: JPEG, PNG
- Max File Size: 5MB

### Story Images
- Aspect Ratio: 9:16 (vertical)
- Resolution: 1080x1920px
- Format: JPEG, PNG
- Max File Size: 15MB

### Videos (Clips)
- Aspect Ratio: 9:16 (vertical)
- Resolution: 1080x1920px (max)
- Format: MP4 (H.264)
- Duration: 15s - 90s
- Max File Size: 100MB

---

## 🔧 Implementation Guidelines

### Component Library
- Use **shadcn/ui** for base components (React)
- Build custom components on top
- Ensure cross-platform consistency

### State Management
- Loading states for all async operations
- Error states with retry options
- Success confirmations with animations

### Performance
- Lazy load images below the fold
- Virtualize long lists (feed, comments)
- Optimize images (compression, format)
- Cache frequently accessed data

---

## 📚 Resources

### Design Files
- Figma: [Link to Figma designs]
- Sketch: [Link to Sketch files]
- Adobe XD: [Link to XD files]

### Design System
- Storybook: [Link to component library]
- Documentation: [Link to design docs]

### Assets
- Icons: [Link to icon library]
- Illustrations: [Link to illustration set]
- Brand Assets: [Link to brand kit]

---

## ✅ Checklist for New Screens

Before implementing a new screen, ensure:

- [ ] Design follows color system
- [ ] Typography scale is consistent
- [ ] Spacing uses 4px grid
- [ ] Touch targets are minimum 44px
- [ ] Animations are defined
- [ ] Loading states are designed
- [ ] Error states are designed
- [ ] Empty states are designed
- [ ] Accessibility is considered
- [ ] Dark mode looks correct
- [ ] Works on all screen sizes
- [ ] Follows navigation patterns

---

**Design Team Contact**: design@picnic-app.com  
**Component Library**: [Storybook Link]  
**Design Review Process**: Submit Figma links in #design channel
